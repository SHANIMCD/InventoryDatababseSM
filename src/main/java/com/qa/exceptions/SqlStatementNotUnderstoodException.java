package com.qa.exceptions;

public class SqlStatementNotUnderstoodException extends RuntimeException {

	private String message;

	public SqlStatementNotUnderstoodException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
