package com.heroes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.CafeVisitingRecordDao;
import com.heroes.vo.CafeVisitingRecordVo;

@Service
public class CafeVisitingRecordService {

  @Autowired
  private CafeVisitingRecordDao cafeVisitingRecordDao;

  public int insert(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return cafeVisitingRecordDao.insert(cafeVisitingRecordVo);
  }
  


}