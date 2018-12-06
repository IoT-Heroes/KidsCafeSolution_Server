package com.heroes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.StatisticsDao;
import com.heroes.vo.StatisticsVo;

@Service
public class StatisticsService {

  @Autowired
  private StatisticsDao statisticsDao;

  public List<StatisticsVo> selectList(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectAirStateHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectAirStateDayList(statisticsVo);

    } else {
      return null;
    }
  }

}
