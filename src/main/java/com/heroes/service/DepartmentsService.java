package com.heroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroes.repository.DepartmentsDao;
import com.heroes.vo.DepartmentsVo;

@Service("DepartmentsService")
public class DepartmentsService {

	@Autowired
	private DepartmentsDao departmentsDao;
	
	public List<DepartmentsVo> getDepartments(DepartmentsVo departmentsVo) {
		return departmentsDao.getDepartments(departmentsVo);		
	}
	
	
	//batch test
	public void testCall() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
	}
	
	//batch test
	public void testCall2() {
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		
	}
}
