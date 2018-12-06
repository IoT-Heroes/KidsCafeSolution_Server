package com.heroes.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.StatisticsVo;

@Repository
public class StatisticsDao {

  @Autowired
  private SqlSession sqlSession;

  public List<StatisticsVo> selectAirStateHourList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectAirStateHourList", statisticsVo);
  }
  
  public List<StatisticsVo> selectAirStateDayList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectAirStateDayList", statisticsVo);
  }
  
}
