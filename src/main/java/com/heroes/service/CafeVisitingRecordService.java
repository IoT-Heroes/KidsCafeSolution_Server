package com.heroes.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.quartz.JobBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.CafeVisitingRecordDao;
import com.heroes.vo.CafeVisitingRecordVo;
import api.COMMONDATA;

@Service("CafeVisitingRecordService")
public class CafeVisitingRecordService extends JobBuilder {

  @Autowired
  private CafeVisitingRecordDao cafeVisitingRecordDao;

  @Autowired
  private BatchService batchService;

  public int insert(CafeVisitingRecordVo cafeVisitingRecordVo) {


    UUID uuid = UUID.randomUUID();

    Date now = new Date();
    Date expire;
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);
    cal.add(Calendar.HOUR, +COMMONDATA.DEFAULT_USING_TIME);
    expire = cal.getTime();

    Timestamp fromTimestamp = new Timestamp(now.getTime());
    Timestamp toTimestamp = new Timestamp(expire.getTime());



    cafeVisitingRecordVo.setStartDate(fromTimestamp.toString());
    cafeVisitingRecordVo.setEndDate(toTimestamp.toString());
    cafeVisitingRecordVo.setUsingTime(2);

    int month = (int) cal.get(cal.MONTH) + 1;
    
   
  //  String expression = "0 " + cal.get(cal.MINUTE) + " " + cal.get(cal.HOUR_OF_DAY) + " " + cal.get(cal.DATE) + " " + month + " ? " + cal.get(cal.YEAR);
  
    
    //test
    int minute = cal.get(cal.MINUTE)+5;
    int hour = cal.get(cal.HOUR_OF_DAY)-2;
    String expression = "0 " + minute + " " + hour + " " + cal.get(cal.DATE) + " " + month + " ? " + cal.get(cal.YEAR);
    //test
    
    Object[] param = new Object[1];
    param[0] = cafeVisitingRecordVo;

    cafeVisitingRecordDao.insert(cafeVisitingRecordVo);
    cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo);

    batchService.registBatch(uuid.toString(), expression, this, "update", param);
    return 0;
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return cafeVisitingRecordDao.selectList(cafeVisitingRecordVo);
  }

  public int update(CafeVisitingRecordVo cafeVisitingRecordVo) {
    cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo);
    return cafeVisitingRecordDao.updateCafeVisitingRecord(cafeVisitingRecordVo);
  }

}
