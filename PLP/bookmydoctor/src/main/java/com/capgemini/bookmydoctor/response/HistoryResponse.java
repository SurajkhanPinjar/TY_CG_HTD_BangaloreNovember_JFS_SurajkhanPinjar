package com.capgemini.bookmydoctor.response;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Availability;
import com.capgemini.bookmydoctor.dto.History;

public class HistoryResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<History> history;
	
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
	public List<History> getHistory() {
		return history;
	}
	public void setHistory(List<History> history) {
		this.history = history;
	}
	
	
}
