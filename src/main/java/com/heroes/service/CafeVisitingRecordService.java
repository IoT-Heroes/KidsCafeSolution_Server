package com.heroes.service;

import java.util.List;
import org.quartz.JobBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.CafeVisitingRecordDao;
import com.heroes.vo.CafeVisitingRecordVo;

@Service("CafeVisitingRecordService")
public class CafeVisitingRecordService extends JobBuilder{

  @Autowired
  private CafeVisitingRecordDao cafeVisitingRecordDao;

  public int insert(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return cafeVisitingRecordDao.insert(cafeVisitingRecordVo);
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return cafeVisitingRecordDao.selectList(cafeVisitingRecordVo);
  }

  public int update(CafeVisitingRecordVo cafeVisitingRecordVo) {
    cafeVisitingRecordDao.updateBandDevice(cafeVisitingRecordVo);
    return cafeVisitingRecordDao.updateCafeVisitingRecord(cafeVisitingRecordVo);
  }

  public void test() {
    System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
  }
}
