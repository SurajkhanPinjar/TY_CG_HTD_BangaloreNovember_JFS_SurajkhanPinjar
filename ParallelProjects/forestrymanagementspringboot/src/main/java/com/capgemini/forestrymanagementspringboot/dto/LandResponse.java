package com.capgemini.forestrymanagementspringboot.dto;

import java.util.List;

public class LandResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Land> landResponse;
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
	public List<Land> getLandResponse() {
		return landResponse;
	}
	public void setLandResponse(List<Land> landResponse) {
		this.landResponse = landResponse;
	}

	
}
