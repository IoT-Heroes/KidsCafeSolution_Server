package com.heroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroes.repository.UserDao;
import com.heroes.repository.ZoneDao;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;

@Service
public class ZoneService {

	@Autowired
	private ZoneDao zoneDao;

	public ZoneVo selectOne(ZoneVo zoneVo) {
		return zoneDao.selectOne(zoneVo);
	}
	
	public List<ZoneVo> selectList() {
		return zoneDao.selectList();
	}
}