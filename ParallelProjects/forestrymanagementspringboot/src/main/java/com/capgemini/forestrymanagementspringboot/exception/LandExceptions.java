package com.capgemini.forestrymanagementspringboot.exception;

public class LandExceptions extends RuntimeException {
	String msg;

	public LandExceptions(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
