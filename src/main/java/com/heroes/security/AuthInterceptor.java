package com.heroes.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.heroes.vo.UserVo;



public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
		throws Exception {
		
		//1. hanlder ���� Ȯ��
		if( handler instanceof HandlerMethod == false ) {
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. Method @Auth �޾ƿ���
		Auth auth = 
			handlerMethod.getMethodAnnotation( Auth.class );
		
		//4. Method�� @Auth �� ���ٸ�,
		//   Class(Type)�� �ٿ� �ִ� @Auth �޾ƿ���
		if( auth == null ) {
			auth = handlerMethod.
				   getMethod().
			       getDeclaringClass().
			       getAnnotation(Auth.class);
		}
		
		//5. @Auth�� �Ⱥپ� �ִ� ���
		if( auth == null ) {
			return true;
		}
		
		//5. @Auth�� �پ� �ֱ� �������� üũ
		HttpSession session = request.getSession();
		
		if( session == null ) { // ������ �ȵǾ� ����
			response.sendRedirect( request.getContextPath() + "/user/wrongaccess" );
			return false;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if( authUser == null ) { // ������ �ȵǾ� ����
			response.sendRedirect( request.getContextPath() + "/user/wrongaccess" );
			return false;
		}

		//6. Role ��������
		Auth.Role role = auth.role();
		
		//7. User Role �����̸� �����Ǿ� �ֱ� ������
		//   ���
		if( role == Auth.Role.USER ) {
			return true;
		}
		
		// 8. Admin Role ���� üũ
		// 'ADMIN' ������ ���� ����ڸ�
		// main ȭ������ �����̷�Ʈ
//		if( authUser.getRole().equals( "ADMIN" ) == false ) {
//			response.sendRedirect( request.getContextPath() + "/user/wrongaccess" );
//			return false;
//		}
		
		//9. Admin Role ���� ���
		return true;
	}
}