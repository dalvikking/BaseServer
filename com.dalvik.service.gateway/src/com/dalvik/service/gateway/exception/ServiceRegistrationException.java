package com.dalvik.service.gateway.exception;

public class ServiceRegistrationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceRegistrationException(String message) {
		super(message);
	}

	public ServiceRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

}
