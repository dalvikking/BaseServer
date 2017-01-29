package com.dalvik.service.gateway.exception;

public class LoadBalancerException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoadBalancerException(String message) {
		super(message);
	}

	public LoadBalancerException(String message, Throwable cause) {
		super(message, cause);
	}

}
