package com.capgemini.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Admin;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	AdminService adminServices;
	
	
	@Test
	void testAddAdmin() {
		Admin admin = new Admin();
		admin.setAdminId(78);
		admin.setAdminName("khan");
		admin.setAdminPassword("Azad@1234");
		admin.setRole("admin");
		assertTrue(adminServices.addAdmin(admin));
		adminServices.deleteAdmin(78);
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
		admin.setAdminId(78);
		admin.setAdminName("khan");
		admin.setAdminPassword("Azad@1234");
		admin.setRole("admin");
		adminServices.addAdmin(admin);
		assertTrue(adminServices.deleteAdmin(78));
	}

}
