package com.heroes.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroes.repository.StatisticsDao;
import com.heroes.repository.ZoneDao;
import com.heroes.vo.IoTMakersDataVo;
import com.heroes.vo.StatisticsVo;
import com.heroes.vo.ZoneVo;
import api.COMMONDATA;
import api.STATUS_CODE;

@Service("IoTMakersService")
public class IoTMakersService {
  @Autowired
  private ZoneDao zoneDao;

  @Autowired
  private StatisticsDao statisticsDao;

  public static String token = null;
  RestTemplate restTemplate = new RestTemplate();


  public int executeAirHourBatch() {

    List<ZoneVo> zoneDeviceList = zoneDao.selectZoneDevice(new ZoneVo());

    for (ZoneVo zoneDevice : zoneDeviceList) {

      if (executeBatch(zoneDevice.getDeviceId(), COMMONDATA.BATCH_TYPE_HOUR) != STATUS_CODE.SUCCESS) {
        return STATUS_CODE.BATCH_ERROR;
      }
    }

    return STATUS_CODE.SUCCESS;
  }


  private int executeBatch(String deviceId, String batchType) {
    int result = getIotMakersData(deviceId, batchType);
    return result;
  }

  /**
   * 이전시간을 구하는 함수
   * 
   * @param date
   * @param type
   * @return
   */
  public Date getPreDate(Date date, String type) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);


    if (type.equals(COMMONDATA.BATCH_TYPE_MINUTE)) {
      cal.add(Calendar.MINUTE, -1);
    } else if (type.equals(COMMONDATA.BATCH_TYPE_HOUR)) {
      cal.add(Calendar.HOUR, -1);
    } else {
    }
    return cal.getTime();

  }


  public int getIotMakersData(String deviceId, String batchType) {

    Date now = new Date();
    Date pre = getPreDate(now, batchType);

    Timestamp fromTimestamp = new Timestamp(pre.getTime());
    Timestamp toTimestamp = new Timestamp(now.getTime());

    int second = 0;
    if (batchType.equals(COMMONDATA.BATCH_TYPE_MINUTE)) {
      second = 60;
    } else if (batchType.equals(COMMONDATA.BATCH_TYPE_HOUR)) {
      second = 3600;
    }

    String targetURL;
    IoTMakersDataVo ioTMakersDataVo = null;

    targetURL = COMMONDATA.IOT_MAKERS_URL + deviceId + "/log?period=9999&from=" + fromTimestamp.getTime() + "&to=" + toTimestamp.getTime() + "&count=";
    if (deviceId.contains(COMMONDATA.BAND_DEVICE_NAMING_RULE)) {


    } else if (deviceId.contains(COMMONDATA.ZONE_DEVICE_NAMING_RULE)) {
      // zone device 일 때
      int requestDataCounter;

      requestDataCounter = (second / COMMONDATA.ZONE_SENSOR_DELAY_TIME) * COMMONDATA.NUM_OF_ZONE_DEVICE_SENSOR;
      targetURL += requestDataCounter;

      try {
        ioTMakersDataVo = getIotMakersData(targetURL);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
        return STATUS_CODE.JSON_PROCESSING_EXCEPTION;
      } catch (IOException e) {
        e.printStackTrace();
        return STATUS_CODE.IOEXCEPTION;
      }

      if (ioTMakersDataVo != null && ioTMakersDataVo.setZoneStatisticsData(fromTimestamp.getTime(), toTimestamp.getTime()) != STATUS_CODE.SUCCESS) {
        return STATUS_CODE.SET_STATISTICS_DATA_ERROR;
      }

      StatisticsVo statisticsVo = new StatisticsVo();

      statisticsVo.setAverageHumidity(ioTMakersDataVo.getAverageHumid());
      statisticsVo.setAverageTemperature(ioTMakersDataVo.getAverageTemp());
      statisticsVo.setId(deviceId);
      statisticsVo.setDate(now.toString());
      statisticsDao.insertAirStateHour(statisticsVo);

    } else {
      return STATUS_CODE.UNKNOWN_DEVICE_ID;

    }
    return STATUS_CODE.SUCCESS;
  }


  public IoTMakersDataVo getIotMakersData(String url) throws JsonProcessingException, IOException {

    HttpHeaders header = new HttpHeaders();
    header.add(HttpHeaders.AUTHORIZATION, COMMONDATA.IOT_MAKERS_TOKEN);

    ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity(header), String.class);

    return parsingData(response.getBody());
  }

  public IoTMakersDataVo parsingData(String jsonData) throws JsonProcessingException, IOException {

    ObjectMapper mapper = new ObjectMapper();
    IoTMakersDataVo pasredData = new IoTMakersDataVo();
    pasredData = mapper.readValue(jsonData, IoTMakersDataVo.class);

    return pasredData;
  }

}
