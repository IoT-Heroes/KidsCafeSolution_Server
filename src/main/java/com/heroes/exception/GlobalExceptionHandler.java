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
import api.ResponseHandler;
import api.Status;
import api.ValidationStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handlerException(Exception exception) {

		Status status = Status.UNKNOWN_EXCEPTION;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		ResponseHandler responseHandler = new ResponseHandler();

		if (exception instanceof DataIntegrityViolationException) {
			status = Status.DATA_INTEGRITY_VIOLATION_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof PSQLException) {
			status = Status.PSQL_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof ParseException) {
			status = Status.PARSE_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof ClassNotFoundException) {
			status = Status.CALSS_NOT_FOUND_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof NoSuchMethodException) {
			status = Status.NO_SUCH_METHOD_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof SchedulerException) {
			status = Status.SCHEDULER_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof SQLException) {
			status = Status.SQL_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof SQLException) {
			status = Status.SQL_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (exception instanceof ValidationException) {
			ValidationStatus validationStatus = ((ValidationException) exception).getStatus();
			return responseHandler.success(validationStatus, ((ValidationException) exception).getObj());
		
		} else {
			status = Status.UNKNOWN_EXCEPTION;
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

		}

		return responseHandler.fail(exception, httpStatus, status);

	}
}
