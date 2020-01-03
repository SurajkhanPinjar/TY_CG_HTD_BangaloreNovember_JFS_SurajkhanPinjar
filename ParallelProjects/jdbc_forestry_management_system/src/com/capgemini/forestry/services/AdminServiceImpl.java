package com.capgemini.forestry.services;

import com.capgemini.forestry.bean.AdminBean;
import com.capgemini.forestry.dao.AdminDaoImpl;
import com.capgemini.forestry.factory.Factory;

public class AdminServiceImpl implements AdminService {
	AdminDaoImpl dao = (AdminDaoImpl) Factory.getAdminDao();
	
	@Override
	public boolean addAdmin(AdminBean bean) {
		return dao.addAdmin(bean) ;
	}

	@Override
	public boolean loginAdmin(int adminid, String password) {
		return dao.loginAdmin(adminid, password);
	}

}
