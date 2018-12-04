package com.heroes.exception;

public class UserDaoException extends RuntimeException {
	
	
	public UserDaoException() {
		super( "UserDao Exception occurs" );
	}

	public UserDaoException( String message ) {
		super(message);
	}

}
