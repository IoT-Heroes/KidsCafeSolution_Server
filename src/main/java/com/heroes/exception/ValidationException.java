package com.heroes.exception;

import api.ValidationStatus;

public class ValidationException extends RuntimeException {
	Exception exception;
	Object obj;
	private final ValidationStatus status;

	public ValidationException(ValidationStatus status, Object obj) {
		super("Validation Exception occurs : " + status.getDetail());
		this.obj = obj;
		this.status = status;
	}

	public ValidationStatus getStatus() {
		return status;
	}

	public Object getObj() {
		return obj;
	}


}
