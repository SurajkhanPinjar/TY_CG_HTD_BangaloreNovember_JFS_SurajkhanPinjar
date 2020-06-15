package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.Test;
import com.capgemini.healthcare.exception.TestException;

@Repository
public class TestDaoImpl implements TestDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addTest(Test test) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(test);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new TestException("Test cannot be Added Please Enter Unique Diagnostic center name");
	}

	@Override
	public boolean removeTest(String centerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Test where centerId= :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", centerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new TestException("Cannot be deleted Enter Valid center Id");
	}

	@Override
	public boolean updateTest(Test test) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Test set testName = :name , centerId = :cId where testId = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("name", test.getTestName());
		query.setParameter("cId", test.getCenterId());
		query.setParameter("id", test.getTestId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new TestException("Sorry Test cannot be updated");
	}

	@Override
	public Test searchTest(int testId) {
		Test test1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		test1 = entityManager.find(Test.class, testId);
		if (test1 != null) {
			return test1;
		}
		throw new TestException("Test Cannot be Found ");

	}

	@Override
	public List<Test> getAllTest() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Test ";
		Query query = entityManager.createQuery(jpql, Test.class);
		List<Test> test = (List<Test>) query.getResultList();
		if (test != null && test.size() != 0) {
			return test;

		}
		throw new TestException("No Tests are Present ");

	}

	@Override
	public List<Test> getAllTestCenter(String centerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Test where centerId=: cid ";
		Query query = entityManager.createQuery(jpql, Test.class);
		query.setParameter("cid", centerId);
		List<Test> test = (List<Test>) query.getResultList();
		if (test != null && test.size() != 0) {
			return test;

		}
		throw new TestException("No Tests are Present ");

	}

}
