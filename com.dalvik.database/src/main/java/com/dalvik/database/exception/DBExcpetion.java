package com.dalvik.database.exception;

public class DBExcpetion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBExcpetion(String message) {
		super(message);
	}

	public DBExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

}
