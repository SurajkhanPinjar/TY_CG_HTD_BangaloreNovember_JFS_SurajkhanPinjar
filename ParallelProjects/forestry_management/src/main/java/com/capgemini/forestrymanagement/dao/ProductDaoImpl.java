package com.capgemini.forestrymanagement.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product p) {

		boolean a = false;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(p);
			transaction.commit();
			a = true;

		} catch (Exception e) {
			System.out.println("Enter Again :");
			transaction.rollback();
		}
		entityManager.close();

		return a;
	}

	@Override
	public boolean deleteProduct(int productId) {
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Product where productId = :pid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pid", productId);
		
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
	public boolean modifyProduct(int productId, String productName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Product set productName = :pname where productId = :pid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pname", productName);
		query.setParameter("pid", productId);
		
		int i = query.executeUpdate();
		transaction.commit();
		if(i>0) {
			System.out.println("Modification Successfulyy :)");
		}else {
			System.out.println("Something Went Wrong :(");
		}
		entityManager.close();
		return true;
	
	}

	@Override
	public Product getProduct(int productId) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Product pr = entityManager.find(Product.class,productId);
		
		entityManager.close();
		return pr;
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Product ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Product> a = (ArrayList<Product>) query.getResultList();
		entityManager.close();
		return a;
	}

}
