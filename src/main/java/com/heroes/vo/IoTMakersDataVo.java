package com.heroes.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import api.STATUS_CODE;

public class IoTMakersDataVo {

  private String responseCode;
  private List<DetailData> data;
  private int averageTemp = 0;
  private int tempCounter = 0;

  private int averageHumid = 0;
  private int humidCounter = 0;

  /**
   * Zone device의 통계를 구하는 함수.
   * @param fromTime
   * @param toTime
   * @return
   */
  public int setZoneStatisticsData(Long fromTime, Long toTime) {

    Long targetTime = null;
    Date targetDate = null;

    for (DetailData detailData : data) {
      try {
        targetDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(detailData.getOccDt());
        targetTime = targetDate.getTime();
      } catch (ParseException e) {
        e.printStackTrace();
        return STATUS_CODE.PARSING_ERROR;
      }


      if (detailData.getAttributes().getHumid() != 0 && fromTime < targetTime && targetTime < toTime) {
        averageHumid += detailData.getAttributes().getHumid();
        humidCounter++;

      } else if (detailData.getAttributes().getTemp() != 0 && fromTime < targetTime && targetTime < toTime) {
        averageTemp += detailData.getAttributes().getTemp();
        tempCounter++;

      }

    }
    averageHumid /= humidCounter;
    averageTemp /= tempCounter;

    return STATUS_CODE.SUCCESS;
  }
  
  
  /**
   * band device의 통계를 구하는 함수. 현재 zone device 참고하여 수정할것.
   * @param fromTime
   * @param toTime
   * @return
   */
  public int setBandStatisticsData(Long fromTime, Long toTime) {

    return 1;
  }


  public int getAverageTemp() {
    return averageTemp;
  }

  public void setAverageTemp(int averageTemp) {
    this.averageTemp = averageTemp;
  }

  public int getTempCounter() {
    return tempCounter;
  }

  public void setTempCounter(int tempCounter) {
    this.tempCounter = tempCounter;
  }

  public int getAverageHumid() {
    return averageHumid;
  }

  public void setAverageHumid(int averageHumid) {
    this.averageHumid = averageHumid;
  }

  public int getHumidCounter() {
    return humidCounter;
  }

  public void setHumidCounter(int humidCounter) {
    this.humidCounter = humidCounter;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public List<DetailData> getData() {
    return data;
  }

  public void setData(List<DetailData> data) {
    this.data = data;
  }



  public static class DetailData {
    private String svcCode;
    private String svcTgtSeq;
    private String groupTagCd;
    private String spotDevSeq;

    private String occDt; // 데이터 수집일시
    private SensorData attributes;

    public String getSvcCode() {
      return svcCode;
    }

    public void setSvcCode(String svcCode) {
      this.svcCode = svcCode;
    }

    public String getSvcTgtSeq() {
      return svcTgtSeq;
    }

    public void setSvcTgtSeq(String svcTgtSeq) {
      this.svcTgtSeq = svcTgtSeq;
    }

    public String getGroupTagCd() {
      return groupTagCd;
    }

    public void setGroupTagCd(String groupTagCd) {
      this.groupTagCd = groupTagCd;
    }

    public String getSpotDevSeq() {
      return spotDevSeq;
    }

    public void setSpotDevSeq(String spotDevSeq) {
      this.spotDevSeq = spotDevSeq;
    }

    public String getOccDt() {
      return occDt;
    }

    public void setOccDt(String occDt) {
      this.occDt = occDt;
    }

    public SensorData getAttributes() {
      return attributes;
    }

    public void setAttributes(SensorData attributes) {
      this.attributes = attributes;
    }

    public static class SensorData {
      @JsonProperty("temp")
      private int temp;
      @JsonProperty("touch")
      private int touch;
      @JsonProperty("humid")
      private int humid;

      // @JsonProperty("Pulse")
      // private int pulse;
      //
      // @JsonProperty("Humid")
      // private int humid;
      // 심박, 걸음 수 추가할것.


      public int getHumid() {
        return humid;
      }

      public void setHumid(int humid) {
        this.humid = humid;
      }

      public int getTemp() {
        return temp;
      }

      public void setTemp(int temp) {
        this.temp = temp;
      }

      public int getTouch() {
        return touch;
      }

      public void setTouch(int touch) {
        this.touch = touch;
      }

    }
  }

}
