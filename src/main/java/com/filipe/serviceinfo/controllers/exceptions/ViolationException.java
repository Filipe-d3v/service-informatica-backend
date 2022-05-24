package com.filipe.serviceinfo.controllers.exceptions;

public class ViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ViolationException(String message, Throwable cause) {
		super(message, cause);

	}

	public ViolationException(String message) {
		super(message);

	}

}