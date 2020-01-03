package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.services.LandServices;

public class LandDaoImpl implements LandServices{

	@Override
	public boolean addLand(Land land) {
		
		boolean a = false;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(land);
			transaction.commit();
			a = true;

		} catch (Exception e) {
			System.out.println("Land Id Already Present :");
			transaction.rollback();
		}
		entityManager.close();

		return a;
		
	}

	@Override
	public boolean deleteLand(int landId) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Land where landId = :id ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("lid", landId);
		
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

	@Override
	public boolean modifyLand(int landId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Land> searchLand(int landId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Land land = entityManager.find(Land.class,landId);
		
		entityManager.close();
		return (List<Land>) land;
	}

	@Override
	public List<Land> getAllLand() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Land ";
		Query query = entityManager.createQuery(jpql);
		List<Land> land = ( List<Land>) query.getResultList();
		entityManager.close();
		return land;
	}

}
