package com.capgemini.forestrymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.exception.ClientExceptions;

public class ClientDaoImpl implements ClientDao {

	@Override
	public boolean addClient(Client client) {
		
		boolean a = false;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(client);
			transaction.commit();
			a = true;

		} catch (Exception e) {
			transaction.rollback();
			throw new ClientExceptions("Duplicate Clients Not Allowed :(");
		}
		entityManager.close();
		return a;

	}

	@Override
	public boolean loginClient(int clientId, String clientPassword) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
		Client client = entityManager.find(Client.class,clientId);
		entityManager.close();
		
		if (client.getClientPassword().equals(clientPassword)) {
			return true;
		}
		} catch (Exception e) {
			throw new ClientExceptions("Invalid Client Account");
		}
		return false;
	}

	@Override
	public List<Client> searchClient(int clientId) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		Client client = entityManager.find(Client.class,clientId);
		entityManager.close();
		if (client != null) {
			return (List<Client>) client;
		}
		 throw new ClientExceptions("No clients present\nEnter valid Client Id");
	}

	@Override
	public List<Client> getAllClient() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Client ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Client> a = (ArrayList<Client>) query.getResultList();
		entityManager.close();
		for (Client client : a) {
			if (a != null && !a.isEmpty()) {
				return a;
			}
		}
		throw new ClientExceptions("No Clients Present");
	}

	@Override
	public boolean deleteClient(int clientId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Client where clientId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", clientId);
		
		int i = query.executeUpdate();
		transaction.commit();
		if(i>0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new ClientExceptions("Cannot be Deleted\nPlease Enter Valid Client Id");
		
	}
			 
			 	

}
