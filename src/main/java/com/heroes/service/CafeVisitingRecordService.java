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
import api.Data;
import api.Status;

@Service("CafeVisitingRecordService")
public class CafeVisitingRecordService extends JobBuilder {

  @Autowired
  private CafeVisitingRecordDao cafeVisitingRecordDao;

  @Autowired
  private BatchService batchService;

  Status status;

  public Status insert(CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {

    UUID uuid = UUID.randomUUID();

    Date now = new Date();
    Date expire;
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);
    cal.add(Calendar.HOUR, +Data.DEFAULT_USING_TIME);
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


    if (!cafeVisitingRecordDao.insert(cafeVisitingRecordVo)) {
      return Status.INSERT_FAIL;
    }

    if (!cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo)) {
      return Status.UPDATE_FAIL;
    }

    batchService.registBatch(uuid.toString(), expression, this, "update", param);
    return Status.INSERT_SUCCESS;
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {
    return cafeVisitingRecordDao.selectList(cafeVisitingRecordVo);
  }

  public Status update(CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {

    if (!cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo))
      return Status.UPDATE_FAIL;

    if (!cafeVisitingRecordDao.updateCafeVisitingRecord(cafeVisitingRecordVo))
      return Status.UPDATE_FAIL;

    return Status.UPDATE_SUCCESS;
  }

}
