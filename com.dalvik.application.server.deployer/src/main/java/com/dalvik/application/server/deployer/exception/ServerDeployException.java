package com.dalvik.application.server.deployer.exception;

public class ServerDeployException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerDeployException(String message) {
		super(message);
	}

	public ServerDeployException(String message, Throwable cause) {
		super(message, cause);
	}

}
