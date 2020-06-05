package com.qa.exceptions;

public class ConnectionNotMadeException extends RuntimeException {

	private String message;

	public ConnectionNotMadeException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
