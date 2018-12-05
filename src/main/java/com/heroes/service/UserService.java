package com.heroes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.ChildDao;
import com.heroes.repository.UserDao;
import com.heroes.vo.ChildVo;
import com.heroes.vo.UserVo;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private ChildDao childDao;

  public int insert(UserVo userVo) {
    return userDao.insert(userVo);
  }
  
  public UserVo login(UserVo userVo) {
    UserVo resultUser = userDao.login(userVo);
    return resultUser;

  }
  

  public UserVo selectOne(UserVo userVo) {

    UserVo resultUser = userDao.selectOne(userVo);

    if (resultUser != null) {
      ChildVo childVo = new ChildVo();
      childVo.setUserId(resultUser.getId());
      resultUser.setChild((ArrayList<ChildVo>) childDao.selectListByParentKey(childVo));
    }
    return resultUser;

  }

  public List<UserVo> selectList() {

    List<UserVo> userVoList = userDao.selectList();

    for (UserVo userVo : userVoList) {
      ChildVo childVo = new ChildVo();
      childVo.setUserId(userVo.getId());
      userVo.setChild((ArrayList<ChildVo>) childDao.selectListByParentKey(childVo));
    }

    return userVoList;
  }


}
