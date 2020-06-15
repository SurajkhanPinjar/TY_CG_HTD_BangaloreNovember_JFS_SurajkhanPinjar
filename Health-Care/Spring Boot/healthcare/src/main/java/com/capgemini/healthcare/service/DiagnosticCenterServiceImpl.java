package com.capgemini.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.AppointmentDao;
import com.capgemini.healthcare.dao.DiagnosticCenterDao;
import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.Appointment;
import com.capgemini.healthcare.dto.DiagnosticCenter;
import com.capgemini.healthcare.dto.Test;

@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {

	@Autowired
	private DiagnosticCenterDao diagnosticCenterDao; 
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	
	@Override
	public boolean addCenter(DiagnosticCenter center) {
		
		boolean added = diagnosticCenterDao.addCenter(center);
		
		Test test = new Test();
		String cId = center.getCenterId();
		test.setCenterId(cId);
		test.setTestName("Blood_sugar");
		testDao.addTest(test);
		
		Test test1 = new Test();
		test1.setCenterId(cId);
		test1.setTestName("Blood_group");
		testDao.addTest(test1);
		
		Test test2 = new Test();
		test2.setCenterId(cId);
		test2.setTestName("Blood_pressure");
		testDao.addTest(test2);
		return added;
	}

	@Override
	public boolean removeCenter(String centerId) {
		boolean removed = diagnosticCenterDao.removeCenter(centerId);
		Test test = new Test();
		test.setCenterId(centerId);
		testDao.removeTest(centerId);
		
		Appointment appointment = new Appointment();
		appointment.setCenterId(centerId);
		appointmentDao.removeAppointment(appointment);
		return removed;
	}

	@Override
	public boolean updateCenter(DiagnosticCenter center) {
		boolean updateCenter = diagnosticCenterDao.updateCenter(center);
		
		Appointment appointment = new Appointment();
		appointment.setCenterName(center.getCenterName());
		appointment.setCenterId(center.getCenterId());
		appointmentDao.updateAppointment(appointment);
		
		return updateCenter;
	}

	@Override
	public DiagnosticCenter searchCenter(String centerId) {
		return diagnosticCenterDao.searchCenter(centerId);
	}

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		return diagnosticCenterDao.getAllCenter();
	}

}
