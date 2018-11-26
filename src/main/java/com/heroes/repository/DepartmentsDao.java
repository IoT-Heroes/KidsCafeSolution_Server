package com.heroes.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heroes.vo.DepartmentsVo;

@Repository
public class DepartmentsDao {

	@Autowired
	private SqlSession sqlSession;

	public List<DepartmentsVo> getDepartments(DepartmentsVo departmentsVo) {
		return sqlSession.selectList("departments.getDepartments", departmentsVo);
	}
}
