package com.capgemini.forestrymanagementjdbc.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.AdminBean;

class AdminDaoTest {

	private static AdminDao adminDao = new AdminDaoImpl();
	private static AdminBean admin = new AdminBean();
	
	@BeforeAll
	static void addAdmin() {
		admin.setAdminId(786);
		admin.setAdminName("khan");
		admin.setPassword("suraj");
		admin.setRole("admin");
		adminDao.addAdmin(admin);
	}
	
	@AfterAll
	static void delete() {
		adminDao.deleteAdmin(admin.getAdminId());
	}
	
	@Test
	void testAddAdmin() {
		AdminBean admin1 = new AdminBean();
		admin1.setAdminId(7861);
		admin1.setAdminName("khan");
		admin1.setPassword("suraj");
		admin1.setRole("admin");
		assertTrue(adminDao.addAdmin(admin1));
		adminDao.deleteAdmin(admin1.getAdminId());
	}

	@Test
	void testLoginAdmin() {
		assertTrue(adminDao.loginAdmin(admin.getAdminId(), admin.getPassword()));
		
	}

	@Test
	void testDeleteAdmin() {
		AdminBean admin1 = new AdminBean();
		admin1.setAdminId(7861);
		admin1.setAdminName("khan");
		admin1.setPassword("suraj");
		admin1.setRole("admin");
		adminDao.addAdmin(admin1);
		assertTrue(adminDao.deleteAdmin(admin1.getAdminId()));
	}

}
