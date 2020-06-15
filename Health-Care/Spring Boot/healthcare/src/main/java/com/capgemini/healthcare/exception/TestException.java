package com.capgemini.healthcare.exception;

public class TestException extends RuntimeException{
	String msg;

	public TestException(String message) {
		this.msg = message;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
