package com.heroes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.exception.CustomException;
import com.heroes.repository.StatisticsDao;
import com.heroes.vo.StatisticsVo;
import api.EXCEPTION_CODE;

@Service
public class StatisticsService {

  @Autowired
  private StatisticsDao statisticsDao;

  
  
  public List<StatisticsVo> selectAirstate(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectAirStateHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectAirStateDayList(statisticsVo);
    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }

  public List<StatisticsVo> selectChildActivity(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectChildActivityHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectChildActivityDayList(statisticsVo);
    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }

  public List<StatisticsVo> selectChildPulse(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("M")) {
      return statisticsDao.selectChildPulseMinuteList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectChildPulseDayList(statisticsVo);

    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }

  public List<StatisticsVo> selectIncome(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectIncomeHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectIncomeDayList(statisticsVo);
    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }

  public List<StatisticsVo> selectUsingFrequency(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectUsingFrequencyHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectUsingFrequencyDayList(statisticsVo);

    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }

  public List<StatisticsVo> childusingfrequency(StatisticsVo statisticsVo) {

    return statisticsDao.childusingfrequency(statisticsVo);
  }

  public List<StatisticsVo> selectZonefrequency(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectZonefrequencyHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectZonefrequencyDayList(statisticsVo);

    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }

  public List<StatisticsVo> selectZonefrequencybyage(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals("H")) {
      return statisticsDao.selectZonefrequencybyageHourList(statisticsVo);
    } else if (statisticsVo.getBatchType().equals("D")) {
      return statisticsDao.selectZonefrequencybyageDayList(statisticsVo);
    } else {
      throw new CustomException(EXCEPTION_CODE.BATCH_TYPE_EXCEPTION,"unexcepted batch type : " + statisticsVo.getBatchType());
    }
  }


}
