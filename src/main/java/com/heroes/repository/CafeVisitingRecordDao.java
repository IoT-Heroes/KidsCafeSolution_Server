package com.heroes.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.CafeVisitingRecordVo;
import com.heroes.vo.ChildVo;

@Repository
public class CafeVisitingRecordDao {

  @Autowired
  private SqlSession sqlSession;

  public boolean insert(CafeVisitingRecordVo cafeVisitingRecordVo) {
    if (sqlSession.insert("cafeVisitingRecord.insertCafeVisitingRecord", cafeVisitingRecordVo) < 0) {
      return false;
    }
    return true;
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return sqlSession.selectList("cafeVisitingRecord.selectList", cafeVisitingRecordVo);
  }

  public boolean updateCafeVisitingRecord(CafeVisitingRecordVo cafeVisitingRecordVo) {
    if (sqlSession.update("cafeVisitingRecord.updateCafeVisitingRecord", cafeVisitingRecordVo) < 0) {
      return false;
    }
    return true;
  }

  public boolean updateBandDevice(CafeVisitingRecordVo cafeVisitingRecordVo) {
    if (sqlSession.update("cafeVisitingRecord.updateBandDevice", cafeVisitingRecordVo) < 0) {
      return false;
    }
    return true;

  }
}
