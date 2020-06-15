package com.capgemini.healthcare.exception;

public class UserException extends RuntimeException {
	String msg;

	public UserException(String message) {
		this.msg = message;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
