package com.capgemini.healthcare.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.healthcare.exception.AppointmentException;
import com.capgemini.healthcare.exception.DiagnosticCenterException;
import com.capgemini.healthcare.exception.TestException;
import com.capgemini.healthcare.exception.UserException;
import com.capgemini.healthcare.response.AppointmentResponse;
import com.capgemini.healthcare.response.DiagnosticCenterResponse;
import com.capgemini.healthcare.response.TestResponse;
import com.capgemini.healthcare.response.UserResponse;

@RestControllerAdvice
public class HealthCareControllerAdvice {

	@ExceptionHandler(UserException.class)
	public UserResponse handleUserException(UserException e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setMessage("Exception");
		userResponse.setDescription(e.getMessage());
		return userResponse;
	}
	
	@ExceptionHandler(TestException.class)
	public TestResponse handleTestException(TestException e) {
		TestResponse testResponse = new TestResponse();
		testResponse.setStatusCode(501);
		testResponse.setMessage("Exception");
		testResponse.setDescription(e.getMessage());
		return testResponse;
	}
	
	@ExceptionHandler(AppointmentException.class)
	public AppointmentResponse handleAppointmentException(AppointmentException e) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		appointmentResponse.setStatusCode(501);
		appointmentResponse.setMessage("Exception");
		appointmentResponse.setDescription(e.getMessage());
		return appointmentResponse;
	}
	
	@ExceptionHandler(DiagnosticCenterException.class)
	public DiagnosticCenterResponse handleDiagnosticCenterException(DiagnosticCenterException e) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		diagnosticCenterResponse.setStatusCode(501);
		diagnosticCenterResponse.setMessage("Exception");
		diagnosticCenterResponse.setDescription(e.getMessage());
		return diagnosticCenterResponse;
	}
	
}
