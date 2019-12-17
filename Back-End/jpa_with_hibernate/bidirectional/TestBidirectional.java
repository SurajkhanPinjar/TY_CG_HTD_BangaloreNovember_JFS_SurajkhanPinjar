package com.cap.jpawithhibernate.bidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpahibernate.onetoone.EmployeeInfo;

public class TestBidirectional {
public static void main(String[] args) {

	try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		EmployeeInfo emp = entityManager.find(EmployeeInfo.class, 12);
		System.out.println(emp.getEoi().getPan());
		
	
		
		
		transaction.commit();
//		entityManager.close();
}catch(Exception e) {
	System.out.println("ash");
}
}
}
