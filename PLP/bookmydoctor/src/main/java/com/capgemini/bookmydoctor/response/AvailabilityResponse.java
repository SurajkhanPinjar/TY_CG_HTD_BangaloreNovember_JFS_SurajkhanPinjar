package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Availability;

public class AvailabilityResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<Availability> availability;

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

	public List<Availability> getAvailability() {
		return availability;
	}

	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}

}
