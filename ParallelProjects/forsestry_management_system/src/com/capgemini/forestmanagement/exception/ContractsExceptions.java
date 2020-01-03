package com.capgemini.forestmanagement.exception;

public class ContractsExceptions extends RuntimeException {
	String msg;

	public ContractsExceptions(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
	
	
	
	

}
