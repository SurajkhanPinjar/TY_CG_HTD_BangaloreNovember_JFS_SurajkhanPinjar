package com.capgemini.forestry.dao;

import com.capgemini.forestry.bean.AdminBean;

public interface AdminDao {
	public boolean addAdmin(AdminBean bean);
	public boolean loginAdmin(int adminid, String password);
}
