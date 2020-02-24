
package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Doctor;

public class DoctorResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Doctor> doctor;

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

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

}
