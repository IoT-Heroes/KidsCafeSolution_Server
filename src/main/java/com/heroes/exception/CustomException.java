package com.heroes.exception;

import api.Status;

public class CustomException extends RuntimeException {
	Exception exception;
	private final Status status;

	public CustomException(Status status, String message) {
		super("Exception occurs : " + message);

		this.status = status;
	}

	public CustomException(Exception exception) {
		this.exception = exception;
		this.status = Status.UNKNOWN_EXCEPTION;
	}

	public Status getStatus() {
		return status;
	}
}
