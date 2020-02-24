package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Patient;

public class PatientResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Patient> patient;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

}
