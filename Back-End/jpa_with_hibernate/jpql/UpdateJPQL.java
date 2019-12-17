package com.capgemini.jpahibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateJPQL {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql =  "update Movie set name = 'Thor' where id = 111";
		Query query = entityManager.createQuery(jpql);
//		Query q1 = entityManager.createNamedQuery(j1)

		transaction.begin();
		int l = query.executeUpdate();
		transaction.commit();
		if(l>0) {
			System.out.println("Update Successful :)");
			
		}
	}
}
