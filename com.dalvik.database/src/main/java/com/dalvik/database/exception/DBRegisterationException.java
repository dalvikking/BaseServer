package com.dalvik.database.exception;

import java.util.Properties;

/**
 *
 */
public class DBRegisterationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Properties properties;

	public DBRegisterationException(String message, Throwable cause) {
		super(message, cause);

	}

	public DBRegisterationException(String message) {
		super(message);

	}

	public DBRegisterationException(Throwable cause) {
		super(cause);

	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
