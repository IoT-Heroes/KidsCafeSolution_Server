package com.heroes.exception;

import java.sql.SQLException;
import java.text.ParseException;
import org.postgresql.util.PSQLException;
import org.quartz.SchedulerException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import api.ResponseHelper;
import api.Status;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {  
  
  @ExceptionHandler( Exception.class )
  @ResponseBody
  public ResponseEntity<Object> handlerException(Exception exception) {

    Status status;
    HttpStatus httpStatus;
    
    if (exception instanceof DataIntegrityViolationException) {
      status = Status.DATA_INTEGRITY_VIOLATION_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof PSQLException) {
      status = Status.PSQL_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof ParseException) {
      status = Status.PARSE_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof ClassNotFoundException) {
      status = Status.CALSS_NOT_FOUND_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof NoSuchMethodException) {
      status = Status.NO_SUCH_METHOD_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof SchedulerException) {
      status = Status.SCHEDULER_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof SQLException) {
      status = Status.SQL_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof SQLException) {
      status = Status.SQL_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    }  
    else {
      status = Status.UNKNOWN_EXCEPTION;
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      
    }
    
    
      ResponseHelper responseHelper = new ResponseHelper();
      return responseHelper.fail(exception,httpStatus,status);
      
      
      
      
    }
}
