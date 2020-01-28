package com.capgemini.forestrymanagementspringrest.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementspringrest.dto.Admin;
import com.capgemini.forestrymanagementspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = {TestBeans.class, ORMConfig.class})
class AdminServiceTest {

	@Autowired
	AdminService adminServices;
	
	
	@Test
	void testAddAdmin() {
		Admin admin = new Admin();
		admin.setAdminName("khan");
		admin.setAdminPassword("Azad@1234");
		admin.setAdminEmail("zad@g.com");
		admin.setRole("admin");
		assertTrue(adminServices.addAdmin(admin));
		adminServices.deleteAdmin("khan");
	}

	@Test
	void testLogin() {
		Admin admin = new Admin();
		admin.setAdminName("admin");
		admin.setAdminPassword("Admin@123");
		assertNotNull(adminServices.login(admin));
	}

	@Test
	void testDeleteAdmin() {
		Admin admin = new Admin();
		admin.setAdminName("khan");
		admin.setAdminPassword("Azad@1234");
		admin.setRole("admin");
		adminServices.addAdmin(admin);
		assertTrue(adminServices.deleteAdmin("khan"));
	}

}
