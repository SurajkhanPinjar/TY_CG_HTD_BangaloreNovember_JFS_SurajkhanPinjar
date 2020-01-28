package com.capgemini.forestrymanagementspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementspringboot.dto.Land;
import com.capgemini.forestrymanagementspringboot.exception.LandExceptions;

@Repository
public class LandDaoImpl implements LandDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction transaction;

	@Override
	public boolean addLand(Land land) {

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(land);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		throw new LandExceptions("Land Cannot be Added\nLand Id already Existed");

	}

	@Override
	public boolean deleteLand(int landId) {

		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Land where landId = :id ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", landId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new LandExceptions("Land Details Cannot be Deleted\nEnter Valid Land Id:");
	}

	@Override
	public boolean modifyLand(Land land) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Land set location = :loc, value =: val, ownerName =: ownerName,"
				+ " date=: date where landId = :lid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("loc", land.getLocation());
		query.setParameter("val", land.getValue());
		query.setParameter("ownerName", land.getOwnerName());
		query.setParameter("date", land.getDate());
		query.setParameter("lid", land.getLandId());

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			return true;
		}
		entityManager.close();
		throw new LandExceptions("Land details Cannot be modified, Enter Valid land Id:");


	}

	@Override
	public Land searchLand(int landId) {
		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Land land = entityManager.find(Land.class, landId);
		if (land != null) {
			return land;
		}
		entityManager.close();
		throw new LandExceptions("Land Details cannot be Found Enter Valid Land Id");
	}

	@Override
	public List<Land> getAllLand() {
		entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Land ";
		Query query = entityManager.createQuery(jpql);
		List<Land> land = (List<Land>) query.getResultList();
		if (land != null) {
			return land;
		}
		entityManager.close();
		throw new LandExceptions("No Land Details Present");
	}

}
