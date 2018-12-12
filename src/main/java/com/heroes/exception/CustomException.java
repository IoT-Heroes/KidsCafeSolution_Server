package com.heroes.exception;

public class CustomException extends RuntimeException  {
	
  private final int exceptionType;
  public CustomException(int exceptionType,String message) {
    super( "Exception occurs : " + message );
    this.exceptionType = exceptionType;
  }
}


