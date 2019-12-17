package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class Pract {
	public static void main(String[] args) {

		
		System.out.println("Update ");
//		try {
//			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			EntityTransaction transaction = entityManager.getTransaction();
//			transaction.begin();
//			Movie rec = entityManager.find(Movie.class, 102);
//			rec.setName("Dr.Strange");
//			rec.setRatings("Mind blowing");
//			transaction.commit();
//			entityManager.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		
//		Movie movie =  new Movie();
//		movie.setMovieid(105);
//		movie.setName("KGF");
//		movie.setRatings("gudd");
//		try {
//			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			EntityTransaction transaction = entityManager.getTransaction();
//			transaction.begin();
//			entityManager.persist(movie);
//			System.out.println(movie.getMovieid());
//			System.out.println(movie.getName());
//			System.out.println(movie.getRatings());
//			transaction.commit();
//			entityManager.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		
//		try {
//			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			EntityTransaction transaction = entityManager.getTransaction();
//			transaction.begin();
//			Movie rec = entityManager.find(Movie.class, 100);
//			entityManager.remove(rec);
//			System.out.println(rec);
//			transaction.commit();
//			entityManager.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
}
