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


  public List<StatisticsVo> selectChildActivityHourList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectChildActivityHourList", statisticsVo);
  }

  public List<StatisticsVo> selectChildActivityDayList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectChildActivityDayList", statisticsVo);
  }


  public List<StatisticsVo> selectChildPulseMinuteList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectChildPulseMinuteList", statisticsVo);
  }

  public List<StatisticsVo> selectChildPulseDayList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectChildPulseDayList", statisticsVo);
  }


  public List<StatisticsVo> selectIncomeHourList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectAirStateHourList", statisticsVo);
  }

  public List<StatisticsVo> selectIncomeDayList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectIncomeDayList", statisticsVo);
  }


  public List<StatisticsVo> selectUsingFrequencyHourList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectUsingFrequencyHourList", statisticsVo);
  }

  public List<StatisticsVo> selectUsingFrequencyDayList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectUsingFrequencyDayList", statisticsVo);
  }


  public List<StatisticsVo> selectZoneFrequencyHourList(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.selectZoneFrequencyHourList", statisticsVo);
  }

  public List<StatisticsVo> childusingfrequency(StatisticsVo statisticsVo) {
    return sqlSession.selectList("statistics.childusingfrequency", statisticsVo);
  }


}
