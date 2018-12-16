package com.heroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroes.exception.ValidationException;
import com.heroes.repository.StatisticsDao;
import com.heroes.vo.StatisticsVo;

import api.Data;
import api.ValidationStatus;

@Service
public class StatisticsService {

  @Autowired
  private StatisticsDao statisticsDao;

  
  public List<StatisticsVo> selectAirstate(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
      return statisticsDao.selectAirStateHourList(statisticsVo);
    } else {
      return statisticsDao.selectAirStateDayList(statisticsVo);
    } 
  }

  public List<StatisticsVo> selectChildActivity(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
      return statisticsDao.selectChildActivityHourList(statisticsVo);
    } else {
      return statisticsDao.selectChildActivityDayList(statisticsVo);
    }
  }

  public List<StatisticsVo> selectChildPulse(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_MINUTE)) {
      return statisticsDao.selectChildPulseMinuteList(statisticsVo);
    } else {
      return statisticsDao.selectChildPulseDayList(statisticsVo);
    }
  }

  public List<StatisticsVo> selectIncome(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
      return statisticsDao.selectIncomeHourList(statisticsVo);
    } else {
      return statisticsDao.selectIncomeDayList(statisticsVo);
    }
  }

  public List<StatisticsVo> selectUsingFrequency(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
      return statisticsDao.selectUsingFrequencyHourList(statisticsVo);
    } else {
      return statisticsDao.selectUsingFrequencyDayList(statisticsVo);
    }
  }

  public List<StatisticsVo> childusingfrequency(StatisticsVo statisticsVo) {
    return statisticsDao.childusingfrequency(statisticsVo);
  }

  public List<StatisticsVo> selectZonefrequency(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
      return statisticsDao.selectZonefrequencyHourList(statisticsVo);
    } else {
      return statisticsDao.selectZonefrequencyDayList(statisticsVo);
    }
  }

  public List<StatisticsVo> selectZonefrequencybyage(StatisticsVo statisticsVo) {

    if (statisticsVo.getBatchType().equals(Data.BATCH_TYPE_HOUR)) {
      return statisticsDao.selectZonefrequencybyageHourList(statisticsVo);
    } else {
      return statisticsDao.selectZonefrequencybyageDayList(statisticsVo);
    }
  }


}
