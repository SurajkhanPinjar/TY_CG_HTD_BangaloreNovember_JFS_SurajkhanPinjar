package com.capgemini.forestmanagement.dao;

import com.capgemini.forestmanagement.bean.AdminBean;

public interface AdminDao {
	public boolean addAdmin(AdminBean bean);
	public boolean loginAdmin(Object adminid, String password);

}
