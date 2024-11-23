package com.app.multidb.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public EmployeeAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}