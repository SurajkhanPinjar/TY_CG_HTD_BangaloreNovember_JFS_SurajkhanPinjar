package com.capgemini.forestrymanagement.services;

import com.capgemini.forestrymanagement.dao.AdminDao;
import com.capgemini.forestrymanagement.dto.Admin;
import com.capgemini.forestrymanagement.factory.Factory;

public class AdminServiceImpl implements AdminService {
	AdminDao dao = Factory.getAdminDao();
	@Override
	public boolean addAdmin(Admin admin) {
		return dao.addAdmin(admin);
	}

	@Override
	public boolean loginAdmin(int adminId, String adminPassword) {
		return dao.loginAdmin(adminId, adminPassword);
	}
	
}
