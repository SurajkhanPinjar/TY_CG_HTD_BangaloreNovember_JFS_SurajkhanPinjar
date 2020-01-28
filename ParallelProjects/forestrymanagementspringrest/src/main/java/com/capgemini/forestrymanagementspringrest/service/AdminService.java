package com.capgemini.forestrymanagementspringrest.service;

import com.capgemini.forestrymanagementspringrest.dto.Admin;

public interface AdminService {
	public boolean addAdmin(Admin admin);

	public Admin login(Admin admin);
	
	public boolean deleteAdmin(String adminName);

}
