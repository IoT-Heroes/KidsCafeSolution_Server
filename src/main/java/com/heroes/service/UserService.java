package com.heroes.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.ChildDao;
import com.heroes.repository.UserDao;
import com.heroes.vo.ChildVo;
import com.heroes.vo.UserVo;

import api.Status;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ChildDao childDao;

	public Status insert(UserVo userVo) {
		if (userDao.insert(userVo) == 1) {
			return Status.INSERT_SUCCESS;
		} else {
			return Status.INSERT_FAIL;
		}
	}

	public UserVo login(UserVo userVo) {
		UserVo resultUser = userDao.login(userVo);
		setChild(resultUser);
		return resultUser;
	}

	public List<UserVo> selectList(UserVo userVo) {
		List<UserVo> userVoList = userDao.selectList(userVo);
		for (UserVo resUserVo : userVoList) {
			setChild(resUserVo);
		}
		return userVoList;
	}

	private void setChild(UserVo userVo) {
		if (userVo != null) {
			ChildVo childVo = new ChildVo();
			childVo.setUserId(userVo.getId());
			ArrayList<ChildVo> childList = (ArrayList<ChildVo>) childDao.selectList(childVo);

			for (ChildVo resChildVo : childList) {
				resChildVo.setEatableFoodList(childDao.selectEatableFoodList(resChildVo));
			}
			userVo.setChild(childList);
		}

	}

}
