package com.heroes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.ZoneDao;
import com.heroes.vo.ZoneCoordinateVo;
import com.heroes.vo.ZoneVo;

@Service
public class ZoneService {

  @Autowired
  private ZoneDao zoneDao;

  @Autowired
  private ZoneCoordinate zoneCoordinateDao;

  public ZoneVo selectOne(ZoneVo zoneVo) {

    ZoneVo resultZone = zoneDao.selectOne(zoneVo);

    if (resultZone != null) {
      ZoneCoordinateVo zoneCoordinateVo = new ZoneCoordinateVo();
      zoneCoordinateVo.setZoneId(resultZone.getId());
      resultZone.setCoordinates((ArrayList<ZoneCoordinateVo>) zoneCoordinateDao.selectListByZoneId(zoneCoordinateVo));
    }
    return resultZone;

  }

  public List<ZoneVo> selectList(ZoneVo zoneVo) {

    List<ZoneVo> zoneVoList = zoneDao.selectList(zoneVo);

    for (ZoneVo resZoneVo : zoneVoList) {
      ZoneCoordinateVo zoneCoordinateVo = new ZoneCoordinateVo();
      zoneCoordinateVo.setZoneId(resZoneVo.getId());
      resZoneVo.setCoordinates((ArrayList<ZoneCoordinateVo>) zoneCoordinateDao.selectListByZoneId(zoneCoordinateVo));
    }

    return zoneVoList;
  }
}
