package com.capgemini.forestrymanagementspringrest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestrymanagementspringrest.dto.Client;
import com.capgemini.forestrymanagementspringrest.exception.AdminExceptions;
import com.capgemini.forestrymanagementspringrest.exception.ClientExceptions;

@Repository
public class ClientDaoImpl implements ClientDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addClient(Client client) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(client);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			throw new ClientExceptions("Duplicate Clients Not Allowed :(");
		}

	}

	@Override
	public List<Client> searchClient(int clientId) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Client client = entityManager.find(Client.class, clientId);
		if (client != null) {
			return (List<Client>) client;
		}
		throw new ClientExceptions("No clients present\nEnter valid Client Id");
	}

	@Override
	public List<Client> getAllClient() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "from Client ";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Client> a = (ArrayList<Client>) query.getResultList();
		entityManager.close();

		if (a != null && !a.isEmpty()) {
			return a;
		}
		throw new ClientExceptions("No Clients Present");
	}

	@Override
	public boolean deleteClient(int clientId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "delete from Client where clientId = :cid ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid", clientId);

		int i = query.executeUpdate();
		transaction.commit();
		if (i > 0) {
			System.out.println("Delete Successfulyy :)");
			return true;
		}
		entityManager.close();
		throw new ClientExceptions("Cannot be Deleted\nPlease Enter Valid Client Id");

	}

	@Override
	public Client login(Client client) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from Client where clientId=:id ";
		TypedQuery<Client> query = manager.createQuery(jpql, Client.class);
		query.setParameter("id", client.getClientId());
		try {
			Client clientAccount = query.getSingleResult();
			if (clientAccount.getClientPassword().equals(client.getClientPassword())
					&& clientAccount.getRole().equalsIgnoreCase("client")) {
				return clientAccount;
			}
		} catch (Exception e) {
		}
		throw new AdminExceptions("Invalid Client Account");

	}

}
