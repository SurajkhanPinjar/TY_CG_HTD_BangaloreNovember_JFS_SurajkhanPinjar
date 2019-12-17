package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Transaction;

import com.cap.jpawithhibernate.dto.Movie;

public class Delete {
	public static void main(String[] args) {
		
		EntityManager entityManager ;
		EntityManagerFactory entityManagerFactory ;
		EntityTransaction transaction = null ;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			 transaction = entityManager.getTransaction();
			transaction.begin();
			 Movie record = entityManager.find(Movie.class, 101);
			 entityManager.remove(record);
			 System.out.println("record Record");
			 transaction.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
