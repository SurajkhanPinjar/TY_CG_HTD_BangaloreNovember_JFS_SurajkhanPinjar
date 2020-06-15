package com.capgemini.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.AppointmentDao;
import com.capgemini.healthcare.dto.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDao appointmentDao;

	@Override
	public boolean approveAppointment(Appointment appointment) {
		appointment.setStatus("Approved");
		return appointmentDao.approveAppointment(appointment);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentDao.getAllAppointment();
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		return appointmentDao.updateAppointment(appointment);
	}

	@Override
	public boolean removeAppointment(Appointment appointment) {
		return appointmentDao.removeAppointment(appointment);
	}

}
