package com.capgemini.healthcare.exception;

public class DiagnosticCenterException extends RuntimeException {
	String msg;

	public DiagnosticCenterException(String message) {
		this.msg = message;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
