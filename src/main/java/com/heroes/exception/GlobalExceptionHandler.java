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
import api.STATUS;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {  
  
  @ExceptionHandler( Exception.class )
  @ResponseBody
  public ResponseEntity<Object> handlerException(Exception exception) {

    STATUS status;
    HttpStatus httpStatus;
    
    if (exception instanceof DataIntegrityViolationException) {
      status = STATUS.DATA_INTEGRITY_VIOLATION_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof PSQLException) {
      status = STATUS.PSQL_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof ParseException) {
      status = STATUS.PARSE_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof ClassNotFoundException) {
      status = STATUS.CALSS_NOT_FOUND_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof NoSuchMethodException) {
      status = STATUS.NO_SUCH_METHOD_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof SchedulerException) {
      status = STATUS.SCHEDULER_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof SQLException) {
      status = STATUS.SQL_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    } else if (exception instanceof SQLException) {
      status = STATUS.SQL_EXCEPTION;
      httpStatus = HttpStatus.ALREADY_REPORTED;
      
    }  
    else {
      status = STATUS.UNKNOWN_EXCEPTION;
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      
    }
    
    
      ResponseHelper responseHelper = new ResponseHelper();
      return responseHelper.fail(exception,httpStatus,status);
      
      
      
      
    }
}
