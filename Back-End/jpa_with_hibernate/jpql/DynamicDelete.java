package com.capgemini.jpahibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicDelete {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Movie where id= :mid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("mid", 104 );
		int i = query.executeUpdate();
		if(i>0) {
			System.out.println("\nsucces");
		}
		transaction.commit();
		entityManager.close();

	}
}
