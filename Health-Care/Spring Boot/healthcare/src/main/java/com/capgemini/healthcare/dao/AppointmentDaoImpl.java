package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.Appointment;
import com.capgemini.healthcare.exception.AppointmentException;
import com.capgemini.healthcare.exception.DiagnosticCenterException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;



	@Override
	public boolean approveAppointment(Appointment appointment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Appointment set status=:sts where appointmentId = : aid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sts", appointment.getStatus());
		query.setParameter("aid", appointment.getAppointmentId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new AppointmentException("Sorry Appointment cannot be  Modified ");
	}

	@Override
	public List<Appointment> getAllAppointment() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Appointment";
		Query query = entityManager.createQuery(jpql, Appointment.class);
		List<Appointment> appointment = (List<Appointment>) query.getResultList();
		if (appointment != null && appointment.size() != 0) {
			return appointment;

		}
		throw new AppointmentException("No Appointments are Present ");

	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Appointment set centerName=: cname where centerId = : cid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", appointment.getCenterId());
		query.setParameter("cname", appointment.getCenterName());
		
		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new AppointmentException("Cannot be deleted Enter Valid Center Id");

	}

	@Override
	public boolean removeAppointment(Appointment appointment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Appointment where centerId= :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", appointment.getCenterId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new AppointmentException("Cannot be deleted Enter Valid Center Id");

	}

}
