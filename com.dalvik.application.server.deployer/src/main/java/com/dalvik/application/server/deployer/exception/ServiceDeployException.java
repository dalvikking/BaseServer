package com.dalvik.application.server.deployer.exception;

public class ServiceDeployException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceDeployException(String message) {
		super(message);
	}

	public ServiceDeployException(String message, Throwable cause) {
		super(message, cause);
	}

}
