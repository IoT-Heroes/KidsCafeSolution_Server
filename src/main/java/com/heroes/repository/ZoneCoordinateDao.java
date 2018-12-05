package com.heroes.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.ZoneCoordinateVo;

@Repository
public class ZoneCoordinateDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ZoneCoordinateVo> selectListByZoneId(ZoneCoordinateVo zoneCoordinateVo) {
		return sqlSession.selectList("zonecoordinate.selectListByZoneId", zoneCoordinateVo);
	}
}
