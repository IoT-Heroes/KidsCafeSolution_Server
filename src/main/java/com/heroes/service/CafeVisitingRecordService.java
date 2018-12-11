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

    Timestamp fromTimestamp = new Timestamp(expire.getTime());
    Timestamp toTimestamp = new Timestamp(now.getTime());
    
    
    
    
    cafeVisitingRecordVo.setEndDate(toTimestamp.toString());
    cafeVisitingRecordVo.setUsingTime(2);


    String expression = "0/10 * * * * ?";
    Object[] param= new Object[1];
    param[0] = cafeVisitingRecordVo;
    


        batchService.registBatch(uuid.toString(), expression, this, "update", param);
    return cafeVisitingRecordDao.insert(cafeVisitingRecordVo);
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return cafeVisitingRecordDao.selectList(cafeVisitingRecordVo);
  }

  public int update(CafeVisitingRecordVo cafeVisitingRecordVo) {
    System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo);
    return cafeVisitingRecordDao.updateCafeVisitingRecord(cafeVisitingRecordVo);
  }

  public void test() {
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
  }
}
