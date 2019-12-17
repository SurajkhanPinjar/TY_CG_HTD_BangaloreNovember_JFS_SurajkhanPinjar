package com.cap.jpawithhibernate.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpahibernate.manytoone.Experience_Info;
import com.capgemini.jpahibernate.onetoone.EmployeeInfo;

public class TestManyToMany {
	public static void main(String[] args) {
		EmployeeInfo emp = new EmployeeInfo();
		emp.setEid(12);
		emp.setEmail("Sdzx");
		emp.setEname("Sudrxzasja");
		emp.setPassword("d12ass");
		
		EmployeeInfo emp1 = new EmployeeInfo();
		emp1.setEid(1101);
		emp1.setEmail("Sdskhsan@comaas");
		emp1.setEname("Sudrsasjaadfdsss");
		emp1.setPassword("d12a34aasss");
		
		ArrayList<EmployeeInfo > aList = new ArrayList<EmployeeInfo>();
		aList.add(emp);
		aList.add(emp1);
		
		TrainingInfo  ti = new TrainingInfo();
		ti.setName("Jav");
		ti.setTid(11);
		ti.setDuration(2);
		ti.setEList(aList);
		
		EntityManager entityManager = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			 entityManager = entityManagerFactory.createEntityManager();
			 EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(ti);
			
			transaction.commit();
			System.out.println("Added SuccessFully");
//			entityManager.close();
			}
			catch(Exception e){
				System.out.println("Something went Wrong");
				
			}
	}

}
