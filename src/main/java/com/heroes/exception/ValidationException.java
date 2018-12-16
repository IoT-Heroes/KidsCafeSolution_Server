package com.heroes.exception;

import api.Status;

public class ValidationException extends RuntimeException {
	Exception exception;
	private final Status status;

	public ValidationException(Status status, String message) {
		super("Exception occurs : " + message);

		this.status = status;
	}
	
	public ValidationException(Status status) {
		super("Validation Exception occurs : " + status.getDetail());

		this.status = status;
	}


	public ValidationException(Exception exception) {
		this.exception = exception;
		this.status = Status.UNKNOWN_EXCEPTION;
	}

	public Status getStatus() {
		return status;
	}
}
