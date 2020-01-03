package com.capgemini.forestmanagement.exception;

public class SchedulerExceptions extends RuntimeException {
	String msg;

	public SchedulerExceptions(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
	
	

}
