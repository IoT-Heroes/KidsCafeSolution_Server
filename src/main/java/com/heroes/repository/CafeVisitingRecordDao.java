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

  public int insert(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return sqlSession.insert("cafeVisitingRecord.insertCafeVisitingRecord", cafeVisitingRecordVo);
  }

  public List<CafeVisitingRecordVo> selectList(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return sqlSession.selectList("cafeVisitingRecord.selectList", cafeVisitingRecordVo);
  }
  
  public int updateCafeVisitingRecord(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return sqlSession.update("cafeVisitingRecord.updateCafeVisitingRecord", cafeVisitingRecordVo);
  }
  
  public int updateBandDevice(CafeVisitingRecordVo cafeVisitingRecordVo) {
    return sqlSession.update("cafeVisitingRecord.updateBandDevice", cafeVisitingRecordVo);
  }
}
