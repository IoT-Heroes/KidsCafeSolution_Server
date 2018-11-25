package com.heroes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroes.repository.UserDao;
import com.heroes.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean join( UserVo userVo ) {
	//	return userDao.insert( userVo ) == 1;
		return true;
	}
	
	public UserVo getUser(String no) {
		//return userDao.get(no);
		return null;
	}
	
	public UserVo getUser(String no,String password) {
		//return userDao.get(no,password);
		return null;
	}
	/*	
	public int updateLoginTime(String no) {
		return userDao.updateLoginTime(no);
	}
	
	public List<UserVo> getTeamList(){
		return userDao.getTeamList();
		
	}	
	public List<UserVo> getPositionList(){
		return userDao.getPositionList();
		
	}
	public List<UserVo> getNotApproved(){
		return userDao.getNotApproved();
		
	}
	
	public int approveJoin(UserVo userVo) {
		return userDao.approveJoin(userVo);
	}*/
}
