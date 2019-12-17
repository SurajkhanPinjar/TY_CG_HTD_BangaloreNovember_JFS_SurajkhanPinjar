package com.capgemini.jpahibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Movie where id=111";
		Query query = entityManager.createQuery(jpql);
		int i = query.executeUpdate();
		transaction.commit();
		if(i>0) {
			System.out.println("Delete Successfulyy :)");
		}else {
			System.out.println("Something Went Wrong :(");
		}
		entityManager.close();
	}
}
