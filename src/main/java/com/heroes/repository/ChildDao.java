package com.heroes.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.ChildVo;

@Repository
public class ChildDao {

  @Autowired
  private SqlSession sqlSession;

  public List<ChildVo> selectListByParentKey(ChildVo childVo) {
    return sqlSession.selectList("child.selectListByParentKey", childVo);
  }
}
