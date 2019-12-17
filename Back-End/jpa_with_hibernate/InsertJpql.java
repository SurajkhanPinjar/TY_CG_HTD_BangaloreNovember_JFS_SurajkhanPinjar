package com.cap.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InsertJpql {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran= em.getTransaction();
		tran.begin();
		String query = "insert into Movie values (111, 'hello', 'hi')";
//		String  query = "insert into Movie values (?,?,?)";
		Query q = em.createNativeQuery(query);
		if(((javax.persistence.Query) q).executeUpdate()>0) {
			System.out.println("up");
			tran.commit();
			
		} else {
			System.out.println("not");
		}
	}

}
