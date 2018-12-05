package com.heroes.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;

@Repository
public class UserDao {

  @Autowired
  private SqlSession sqlSession;

  public int insert(UserVo userVo) {
    return sqlSession.insert("user.insertUser", userVo);
  }

  public UserVo login(UserVo userVo) {
    return sqlSession.selectOne("user.login", userVo);
  }
  
  public UserVo selectOne(UserVo userVo) {
    return sqlSession.selectOne("user.selectOne", userVo);
  }

  public List<UserVo> selectList() {
    return sqlSession.selectList("user.selectList");
  }

}
