package com.heroes.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.CafeVisitingRecordVo;

@Repository
public class CafeVisitingRecordDao {

  @Autowired
  private SqlSession sqlSession;

  public int insert(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return sqlSession.insert("cafeVisitingRecord.insertCafeVisitingRecord", cafeVisitingRecordVo);
  }

}
