package com.dalvik.database.exception;

import java.util.Properties;

/**
 *
 */
public class DBSQLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Properties properties;

	public DBSQLException(String message, Throwable cause) {
		super(message, cause);

	}

	public DBSQLException(String message) {
		super(message);

	}

	public DBSQLException(Throwable cause) {
		super(cause);

	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
