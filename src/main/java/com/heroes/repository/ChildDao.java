package com.heroes.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.ChildVo;
import com.heroes.vo.FoodVo;
import com.heroes.vo.UserVo;

@Repository
public class ChildDao {

  @Autowired
  private SqlSession sqlSession;


  public int insert(ChildVo childVo) {
    return sqlSession.insert("child.insertChild", childVo);
  }
  
  public List<ChildVo> selectList(ChildVo childVo) {
    return sqlSession.selectList("child.selectList",childVo);
  }
  
  public List<FoodVo> selectEatableFoodList(ChildVo childVo) {
    return sqlSession.selectList("child.selectEatableFoodList",childVo);
  }
  
  
}
