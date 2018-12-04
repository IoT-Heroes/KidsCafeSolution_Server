package com.heroes.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heroes.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public int insert(UserVo userVo) {
			return sqlSession.insert("user.insertUser", userVo);		
	}
	
	
//	public int insert( UserVo vo ) {
//		int count = sqlSession.insert("user.insert", vo);
//		return count;
//	}	
//	
//	public UserVo get( String employeeNo ) {
//		return sqlSession.selectOne( "user.getByNo", employeeNo );
//	}
//	
//	
//	public UserVo get( String employeeNo, String password ) throws UserDaoException {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("employeeNo", employeeNo);
//		map.put("password", password);
//		UserVo vo = sqlSession.selectOne("user.getByemployeeNoAndPassword", map);
//		
//		return vo;
//	}
//	
//	
//	public List<UserVo> getNotApproved(){
//		return sqlSession.selectList("user.getnotapproved");
//		
//	}
//	public int approveJoin( UserVo userVo) {
//		return sqlSession.update("user.approvejoin", userVo );
//		
//	}
}