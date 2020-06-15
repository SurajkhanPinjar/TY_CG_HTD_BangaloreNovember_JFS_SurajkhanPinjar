package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.Appointment;

public interface AppointmentDao {
	public boolean approveAppointment(Appointment appointment);

	public List<Appointment> getAllAppointment();

	public boolean updateAppointment(Appointment appointment);

	public boolean removeAppointment(Appointment appointment);

}
