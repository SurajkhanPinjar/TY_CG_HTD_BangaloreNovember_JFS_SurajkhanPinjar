package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.ClientBean;
import com.capgemini.forestrymanagementjdbc.dao.ClientDao;
import com.capgemini.forestrymanagementjdbc.dao.ClientDaoImpl;

class ClientSevicesTest {

	private static ClientSevices clientServices = new ClientServicesImpl();
	private static ClientBean client = new ClientBean();
	
	@BeforeAll
	static void addScheduler() {
		client.setClientId(786);
		client.setClientName("khan");
		client.setClientPassword("kingkhan");
		client.setRole("client");
		clientServices.addClient(client);
	}
	
	@AfterAll
	static void delete() {
		clientServices.deleteClient(client.getClientId(), client.getClientPassword());
	}
	

	
	@Test
	void testAddClient() {
		ClientBean client1 = new ClientBean();
		client1.setClientId(7860);
		client1.setClientName("khan");
		client1.setClientPassword("kingkhan");
		client1.setRole("client");
		assertTrue(clientServices.addClient(client1));
		clientServices.deleteClient(client1.getClientId(), client1.getClientPassword());
	}

	@Test
	void testLoginClient() {
		assertTrue(clientServices.loginClient(client.getClientId(), client.getClientPassword()));
	}

	@Test
	void testSearchClient() {
	}

	@Test
	void testGetAllClient() {
		assertNotNull(clientServices.getAllClient());
	}

	@Test
	void testDeleteClient() {
		ClientBean client1 = new ClientBean();
		client1.setClientId(7860);
		client1.setClientName("khan");
		client1.setClientPassword("kingkhan");
		client1.setRole("client");
		clientServices.addClient(client1);
		assertTrue(clientServices.deleteClient(client1.getClientId(), client1.getClientPassword()));

	}

}
