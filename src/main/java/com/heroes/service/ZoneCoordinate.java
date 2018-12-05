package com.heroes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.UserDao;
import com.heroes.repository.ZoneCoordinateDao;
import com.heroes.repository.ZoneDao;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneCoordinateVo;
import com.heroes.vo.ZoneVo;

@Service
public class ZoneCoordinate {

  @Autowired
  private ZoneCoordinateDao zoneCoordinateDao;

  public List<ZoneCoordinateVo> selectListByZoneId(ZoneCoordinateVo zoneCoordinateVo) {
    return zoneCoordinateDao.selectListByZoneId(zoneCoordinateVo);
  }
}
