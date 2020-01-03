package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.exception.AdminExceptions;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean addAdmin(Admin admin) {
		boolean a = false;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(admin);
			transaction.commit();
			a = true;
			return a;

		} catch (Exception e) {
			throw new AdminExceptions("Duplicate Id Not Allowed");
		}
	
	}

	@Override
	public boolean loginAdmin(Object adminId, String adminPassword) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			
		Admin admin = entityManager.find(Admin.class,adminId);
		entityManager.close();
		
		if (admin.getAdminPassword().equals(adminPassword)) {
			return true;
		}
		} catch (Exception e) {
			System.err.println("Invalid Admin");
		}
		return false;
		
		
	}

}