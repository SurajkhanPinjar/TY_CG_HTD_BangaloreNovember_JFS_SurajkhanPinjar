package com.capgemini.healthcare.exception;

public class AppointmentException extends RuntimeException {
	
	String msg;

	public AppointmentException(String message) {
		this.msg = message;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
