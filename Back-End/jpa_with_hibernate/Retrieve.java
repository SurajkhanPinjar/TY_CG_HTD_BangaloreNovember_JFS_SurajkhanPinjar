package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cap.jpawithhibernate.dto.Movie;

public class Retrieve {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Movie record = entityManager.find(Movie.class,100);
		System.out.println("Movie Id :"+record.getMovieid());;
		System.out.println("Movie name :"+record.getName());
		System.out.println("Movie Ratings :"+record.getRatings());
	}// ENd Of Main Method :
}// End of the class :
