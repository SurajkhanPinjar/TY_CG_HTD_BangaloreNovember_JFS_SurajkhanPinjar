package com.capgemini.forestrymanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementspringrest.dto.Admin;
import com.capgemini.forestrymanagementspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = {TestBeans.class, ORMConfig.class})
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
