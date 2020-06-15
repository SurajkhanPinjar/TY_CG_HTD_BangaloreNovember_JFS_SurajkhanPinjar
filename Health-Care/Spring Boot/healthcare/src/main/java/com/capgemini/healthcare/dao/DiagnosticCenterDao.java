package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.DiagnosticCenter;

public interface DiagnosticCenterDao {
	public boolean addCenter(DiagnosticCenter center);

	public boolean removeCenter(String centerId);

	public boolean updateCenter(DiagnosticCenter center);

	public DiagnosticCenter searchCenter(String centerId);

	public List<DiagnosticCenter> getAllCenter();

}
