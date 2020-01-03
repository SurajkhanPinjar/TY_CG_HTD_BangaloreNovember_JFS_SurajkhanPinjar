package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.dto.Scheduler;

public class SchedulerDaoImpl implements SchedulerDao{

	@Override
	public boolean addScheduler(Scheduler scheduler) {
		boolean a = false;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(scheduler);
			transaction.commit();
			a = true;
			return a;

		} catch (Exception e) {
			System.out.println("Duplicate Scheduler Not Allowed :(");
			transaction.rollback();
		}
		entityManager.close();
		return false;
		
	}


	@Override
	public boolean loginScheduler(int schedulerId, String schedulerPassword) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			
		Scheduler scheduler = entityManager.find(Scheduler.class,schedulerId);
		entityManager.close();
		
		if (scheduler.getSchedulerPassword().equals(schedulerPassword)) {
			return true;
		}
		} catch (Exception e) {
			System.err.println("Invalid Admin");
		}
		return false;
	
	}

	@Override
	public List<Scheduler> getAllScheduler() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Scheduler ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Scheduler> scheduler = (ArrayList<Scheduler>) query.getResultList();
		entityManager.close();
		return scheduler;
	
	}

	@Override
	public List<Scheduler> searchScheduler(int schedulerId) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Scheduler scheduler = entityManager.find(Scheduler.class,schedulerId);
		
		entityManager.close();
		return (List<Scheduler>) scheduler;
		
	}

	@Override
	public boolean deleteScheduler(int schedulerId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Scheduler where schedulerId = : sid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sid", schedulerId);
		
		int i = query.executeUpdate();
		transaction.commit();
		if(i>0) {
			System.out.println("Delete Successfulyy :)");
		}else {
			System.out.println("Something Went Wrong :(");
		}
		entityManager.close();
		return true;
	}

	public boolean modifyScheduler(int schedulerId,  String schedulerName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Scheduler set schedulerName = :sname where schedulerId = :sid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pname",  schedulerName);
		query.setParameter("sid", schedulerId);
		
		int i = query.executeUpdate();
		transaction.commit();
		if(i>0) {
			System.out.println("Modification Successfulyy :)");
			return true;
		}else {
			System.out.println("Something Went Wrong :(");
		}
		entityManager.close();
		return false;
	}


	@Override
	public boolean modifySchedulerPass(int schedulerId, String schedulerPassword) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Scheduler set schedulerName = :pass where schedulerId = :sid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pass",  schedulerPassword);
		query.setParameter("sid", schedulerId);
		
		int i = query.executeUpdate();
		transaction.commit();
		if(i>0) {
			System.out.println("Modification Successfulyy :)");
			return true;
		}else {
			System.out.println("Something Went Wrong :(");
		}
		entityManager.close();
		return false;
	
	}


	

	
	
}
