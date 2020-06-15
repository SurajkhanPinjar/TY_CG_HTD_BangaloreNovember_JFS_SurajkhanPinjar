package com.capgemini.healthcare.service;

import java.util.List;

import com.capgemini.healthcare.dto.Appointment;

public interface AppointmentService {
	
	public boolean approveAppointment(Appointment appointment);

	public List<Appointment> getAllAppointment();
	
	public boolean updateAppointment(Appointment appointment);
	
	public boolean removeAppointment(Appointment appointment);

}
