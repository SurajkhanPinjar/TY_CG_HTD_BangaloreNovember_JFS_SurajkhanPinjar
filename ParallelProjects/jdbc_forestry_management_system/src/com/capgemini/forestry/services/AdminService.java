package com.capgemini.forestry.services;

import com.capgemini.forestry.bean.AdminBean;

public interface AdminService {
	public boolean addAdmin(AdminBean bean);
	public boolean loginAdmin(int adminid, String password);
	

}
