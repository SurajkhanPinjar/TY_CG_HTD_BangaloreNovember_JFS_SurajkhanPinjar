package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class InsertDemo {
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setMovieid(102);
		movie.setName("The Avengers");
		movie.setRatings("Super");
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			 entityManager = entityManagerFactory.createEntityManager();
			 transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(movie);
			System.out.println("record Saved");
			transaction.commit();
	
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
	}
	

}
