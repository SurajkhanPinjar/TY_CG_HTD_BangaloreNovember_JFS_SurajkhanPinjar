package com.capgemini.jpahibernate.jpql;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.cap.jpawithhibernate.dto.Movie;

public class JpqlClass {
	public static void main(String[] args) {
		
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = entityManager.getTransaction();
//	String jpql = "from Movie";
	String jpql = "Select name from Movie";
	Query query = entityManager.createQuery(jpql);
	List<String> record = query.getResultList();
	for (String string : record) {
		System.out.println(string);
	}
//	for (Movie movie : record) {
//		System.out.println("Movie id: " + movie.getMovieid());
//		System.out.println("Movie Name: "+ movie.getName());
//		System.out.println("Movie Ratings :"+ movie.getRatings());
//	}
	}
}
