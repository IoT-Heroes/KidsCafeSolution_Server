package com.heroes.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.quartz.JobBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.exception.CustomException;
import com.heroes.repository.CafeVisitingRecordDao;
import com.heroes.vo.CafeVisitingRecordVo;
import api.COMMONDATA;
import api.STATUS;

@Service("CafeVisitingRecordService")
public class CafeVisitingRecordService extends JobBuilder {

  @Autowired
  private CafeVisitingRecordDao cafeVisitingRecordDao;

  @Autowired
  private BatchService batchService;

  STATUS status;

  public STATUS insert(CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {


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


    // test 할 땐 minute++을 해서 테스트
    int minute = cal.get(cal.MINUTE);
    int hour = cal.get(cal.HOUR_OF_DAY);

    String expression = "0 " + minute + " " + hour + " " + cal.get(cal.DATE) + " " + month + " ? " + cal.get(cal.YEAR);
    // test

    Object[] param = new Object[1];
    param[0] = cafeVisitingRecordVo;

    cafeVisitingRecordDao.insert(cafeVisitingRecordVo);
    cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo);

    batchService.registBatch(uuid.toString(), expression, this, "update", param);

    return STATUS.SUCCESS;
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {
    return cafeVisitingRecordDao.selectList(cafeVisitingRecordVo);
  }

  public STATUS update(CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {
    cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo);
    int updated = cafeVisitingRecordDao.updateCafeVisitingRecord(cafeVisitingRecordVo);
    if (updated > -1)
      return STATUS.UPDATE_SUCCESS;
    else
      return STATUS.UPDATE_FAIL;
  }

}
