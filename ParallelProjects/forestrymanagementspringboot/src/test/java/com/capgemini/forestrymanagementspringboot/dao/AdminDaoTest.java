package com.capgemini.forestrymanagementspringboot.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dto.Admin;

@SpringBootTest
class AdminDaoTest {

	@Autowired
	AdminDao adminDao;
	
	
	@Test
	void testAddAdmin() {
		Admin admin = new Admin();
		admin.setAdminId(78);
		admin.setAdminName("khan");
		admin.setAdminPassword("azad");
		admin.setRole("admin");
		assertTrue(adminDao.addAdmin(admin));
		adminDao.deleteAdmin(78);
	}

	@Test
	void testLogin() {
		Admin admin = new Admin();
		admin.setAdminName("admin");
		admin.setAdminPassword("Admin@123");
		assertNotNull(adminDao.login(admin));
	}

	@Test
	void testDeleteAdmin() {
		Admin admin = new Admin();
		admin.setAdminId(78);
		admin.setAdminName("khan");
		admin.setAdminPassword("azad");
		admin.setRole("admin");
		adminDao.addAdmin(admin);
		assertTrue(adminDao.deleteAdmin(78));
	}

}
