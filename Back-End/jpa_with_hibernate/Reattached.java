package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class Reattached {

	public static void main(String[] args) {
		
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			 entityManager = entityManagerFactory.createEntityManager();
			 transaction = entityManager.getTransaction();
			 transaction.begin();
			 Movie record = entityManager.find(Movie.class, 102); //All the data storing in the Movie
			 System.out.println(entityManager.contains(record));
			 entityManager.detach(record);
			 System.out.println(entityManager.contains(record));
			 Movie reattachMovie = entityManager.merge(record);
			 reattachMovie.setName("IronMan3");
//			 record.setName("IronMan2");
			 System.out.println("Record Update");
			 transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
}
