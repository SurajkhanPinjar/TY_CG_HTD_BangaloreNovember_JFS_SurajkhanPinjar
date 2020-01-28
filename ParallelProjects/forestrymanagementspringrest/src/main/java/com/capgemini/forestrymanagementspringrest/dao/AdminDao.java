package com.capgemini.forestrymanagementspringrest.dao;

import com.capgemini.forestrymanagementspringrest.dto.Admin;

public interface AdminDao {
	public boolean addAdmin(Admin admin);

	public Admin login(Admin admin);
	
	public boolean deleteAdmin(String adminName);
}
