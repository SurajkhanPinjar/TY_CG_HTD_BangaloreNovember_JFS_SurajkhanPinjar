package com.capgemini.jpahibernate.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToOne {
	public static void main(String[] args) {
		EmployeeInfo emp = new EmployeeInfo();
		emp.setEid(10000);
		emp.setEmail("Skhan@comas");
		emp.setEname("Surajas");
		emp.setPassword("1234as");
		
		EmployeOtherInfo eoi = new EmployeOtherInfo();
		eoi.setId(1011);
		eoi.setPan(1234567890);
		eoi.setFname("safHp");
		eoi.setMname("rFasp");
		eoi.setEmployeeInfo(emp);
		
		try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(eoi);
		transaction.commit();
		System.out.println("Added SuccessFully");
//		entityManager.close();
		}
		catch(Exception e){
			System.out.println("Something went Wrong");
			
		}
	}

}
