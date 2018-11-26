package com.heroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroes.repository.DepartmentsDao;
import com.heroes.vo.DepartmentsVo;

@Service
public class DepartmentsService {

	@Autowired
	private DepartmentsDao departmentsDao;
	
	public List<DepartmentsVo> getDepartments(DepartmentsVo departmentsVo) {
		return departmentsDao.getDepartments(departmentsVo);		
	}
}
