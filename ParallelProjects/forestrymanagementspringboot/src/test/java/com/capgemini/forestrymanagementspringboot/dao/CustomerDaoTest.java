package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Customer;
@SpringBootTest
class CustomerDaoTest {

	@Autowired
	CustomerDao customerDao;
	
	@Test
	void testAddCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("khan1");
		customer.setCustomerId(201);
		customer.setEmail("skhan1@gmail.com");
		customer.setPostalCode(59122);
		customer.setStreetAdd1("raibag Road1");
		customer.setStreetAdd2("Raibag Road21");
		customer.setTelephone(73531817);
		customer.setTown("kabbur1");
		boolean added = customerDao.addCustomer(customer);
		assertTrue(added);
	
	}

	@Test
	void testDeleteCustomer() {
		assertTrue(customerDao.deleteCustomer(201));
	}

	@Test
	void testGetCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("khan1");
		customer.setCustomerId(200);
		customer.setEmail("skhan1@gmail.com");
		customer.setPostalCode(59122);
		customer.setStreetAdd1("raibag Road1");
		customer.setStreetAdd2("Raibag Road21");
		customer.setTelephone(73531817);
		customer.setTown("kabbur1");
		boolean added = customerDao.addCustomer(customer);
		assertNotNull(customerDao.getCustomer(200));
		customerDao.deleteCustomer(200);
	}

	@Test
	void testGetAllCust() {
		assertNotNull(customerDao.getAllCust());
	}

	@Test
	void testModifyCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("khan1");
		customer.setCustomerId(200);
		customer.setEmail("skhan1@gmail.com");
		customer.setPostalCode(591555);
		customer.setStreetAdd1("raibag ");
		customer.setStreetAdd2("Raibag ");
		customer.setTelephone(73531817);
		customer.setTown("kabbur1");
		customerDao.addCustomer(customer);
		
		assertTrue(customerDao.modifyCustomer(customer));
		customerDao.deleteCustomer(200);
	}

}
