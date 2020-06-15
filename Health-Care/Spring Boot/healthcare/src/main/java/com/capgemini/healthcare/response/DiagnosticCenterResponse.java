package com.capgemini.healthcare.response;

import java.util.List;

import com.capgemini.healthcare.dto.DiagnosticCenter;

public class DiagnosticCenterResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<DiagnosticCenter> diagnosticCenter;

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

	public List<DiagnosticCenter> getDiagnosticCenter() {
		return diagnosticCenter;
	}

	public void setDiagnosticCenter(List<DiagnosticCenter> diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
}
