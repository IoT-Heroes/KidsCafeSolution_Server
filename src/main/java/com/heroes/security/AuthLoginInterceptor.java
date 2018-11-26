package com.heroes.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.heroes.service.UserService;
import com.heroes.vo.UserVo;



public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
		throws Exception {

		String userId = request.getParameter( "userId" );
		String password = request.getParameter( "password" );
		
		
		UserVo userVo = userService.getUser(userId, password);
	//	userService.updateLoginTime(userId);
		
		if( userVo == null ) {
			response.sendRedirect( request.getContextPath() + "/user/login" );
			return false;
		}
		
/*		//���ι��� ���� ȸ���ϰ��
		if( userVo.getIsAuthority().equals("N")) {
			response.sendRedirect( request.getContextPath() + "/user/notapproval" );
			return false;
			
		}*/
		
		// session ó��
		HttpSession session = request.getSession( true );
		session.setAttribute( "authUser", userVo );
		response.sendRedirect( request.getContextPath()+"/board" );

		return false;
	}

}
