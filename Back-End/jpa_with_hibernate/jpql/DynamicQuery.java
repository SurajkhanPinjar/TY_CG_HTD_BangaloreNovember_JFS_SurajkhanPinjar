package com.capgemini.jpahibernate.jpql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicQuery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Movie set name =: nm where  id= :mid";
		Query query = entityManager.createQuery(jpql);
		System.out.println("Enter The Movie Id:");
		query.setParameter("mid", sc.nextInt() );
		System.out.println("Enter The Movie Name To be Modify:");
		query.setParameter("nm", sc.next());
		int i = query.executeUpdate();
		if(i>0) {
			System.out.println("\nsucces");
		}
		transaction.commit();
		entityManager.close();
		
	
}
}
