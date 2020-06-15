package com.capgemini.healthcare.service;

import java.util.List;

import com.capgemini.healthcare.dto.Appointment;
import com.capgemini.healthcare.dto.DiagnosticCenter;
import com.capgemini.healthcare.dto.Test;

public interface DiagnosticCenterService {
	
	public boolean addCenter(DiagnosticCenter center);
	
	public boolean removeCenter(String centerId);
	
	public boolean updateCenter(DiagnosticCenter center);
	
	public DiagnosticCenter searchCenter(String centerId);
	
	public List<DiagnosticCenter> getAllCenter();
	
	
	
	
	
		
}
