package com.capgemini.empspringboots.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.empspringboots.dto.EmployeeResponse;
import com.capgemini.empspringboots.exception.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse handleEmployeeException(EmployeeException e) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDiscription(e.getMessage());
		return response;
		
		
		

		
	}
	
}
