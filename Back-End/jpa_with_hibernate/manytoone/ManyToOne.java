package com.capgemini.jpahibernate.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpahibernate.onetoone.EmployeeInfo;

public class ManyToOne {
public static void main(String[] args) {
	
	EmployeeInfo emp = new EmployeeInfo();
	emp.setEid(100100);
	emp.setEmail("Skhsan@comaas");
	emp.setEname("Surasjaadfdsss");
	emp.setPassword("12a34aass");
	
	Experience_Info ei = new Experience_Info();
	ei.setExpid(100);
	ei.setCompany("tys");
	ei.setDuration(41);
	ei.setEmployeeInfo(emp);
	
	Experience_Info ei1 = new Experience_Info();
	ei1.setExpid(10111);
	ei1.setCompany("tyasd");
	ei1.setDuration(444);
	ei1.setEmployeeInfo(emp);
	
	try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(ei);
		entityManager.persist(ei1);
		
		transaction.commit();
		System.out.println("Added SuccessFully");
//		entityManager.close();
		}
		catch(Exception e){
			System.out.println("Something went Wrong");
			
		}
	
}
}
