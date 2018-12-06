package com.heroes.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heroes.vo.DepartmentsVo;
import com.heroes.vo.FoodVo;

@Repository
public class DataDao {

	@Autowired
	private SqlSession sqlSession;

	public List<FoodVo> selectFoodList() {
		return sqlSession.selectList("data.selectFoodList");
	}
}
