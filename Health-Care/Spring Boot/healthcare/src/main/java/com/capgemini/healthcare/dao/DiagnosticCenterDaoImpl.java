package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.DiagnosticCenter;
import com.capgemini.healthcare.exception.DiagnosticCenterException;

@Repository
public class DiagnosticCenterDaoImpl implements DiagnosticCenterDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addCenter(DiagnosticCenter center) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(center);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new DiagnosticCenterException("Diagnostic center cannot be Added Please Enter Unique Diagnostic center name");
	}

	@Override
	public boolean removeCenter(String centerId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from DiagnosticCenter where centerId= :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", centerId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		throw new DiagnosticCenterException("Cannot be deleted Enter Valid Center Id");
	}

	@Override
	public boolean updateCenter(DiagnosticCenter center) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update DiagnosticCenter set centerName = :name where centerId = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("name", center.getCenterName());
		query.setParameter("id", center.getCenterId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new DiagnosticCenterException("Sorry Diagnostic center cannot be updated");

	}

	@Override
	public DiagnosticCenter searchCenter(String centerId) {
		DiagnosticCenter diagnosticCenter1 = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		diagnosticCenter1 = entityManager.find(DiagnosticCenter.class, centerId);
		if (diagnosticCenter1 != null) {
			return diagnosticCenter1;
		}
		throw new DiagnosticCenterException("Diagnostic Center Cannot be Found ");

	}

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from DiagnosticCenter ";
		Query query = entityManager.createQuery(jpql, DiagnosticCenter.class);
		List<DiagnosticCenter> user = (List<DiagnosticCenter>) query.getResultList();
		if (user != null && user.size() != 0) {
			return user;

		}
		throw new DiagnosticCenterException("No Diagnostic centers are Present ");
	}

}
