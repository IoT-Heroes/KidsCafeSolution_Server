package com.heroes.exception;

public class CustomException extends RuntimeException  {
  Exception exception;
  private final int exceptionType;
  public CustomException(int exceptionType,String message) {
    super( "Exception occurs : " + message );
    
    this.exceptionType = exceptionType;
  }
  
  public CustomException(Exception exception) {
    this.exception = exception;
    this.exceptionType = 0;
  }
}

