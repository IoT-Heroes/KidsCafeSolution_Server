package com.heroes.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;

@Repository
public class ZoneDao {
	@Autowired
	private SqlSession sqlSession;

	public ZoneVo selectOne(ZoneVo zoneVo) {
		return sqlSession.selectOne("zone.selectOne", zoneVo);
	}

	public List<ZoneVo> selectList(ZoneVo zoneVo) {
		return sqlSession.selectList("zone.selectList",zoneVo);
	}

}
