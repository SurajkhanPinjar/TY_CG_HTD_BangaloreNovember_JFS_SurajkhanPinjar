package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.AdminBean;
import com.capgemini.forestmanagement.exception.AdminExceptions;

public class AdminDaoImpl  implements AdminDao{
	
	private List<AdminBean> l1 = new ArrayList<AdminBean>();
	AdminBean bean1 = new AdminBean();
	
	@Override
	public boolean addAdmin(AdminBean bean) {
		for (AdminBean adminBean : l1) {
			if(adminBean.getAdminId()==bean.getAdminId()) {
				System.out.println("admin id Already Exist:");
				throw new AdminExceptions("Admin Cannot Be Added");
			} 
		}
		l1.add(bean);
		return true;
	}

	@Override
	public boolean loginAdmin(Object adminid, String password) {
		for (AdminBean adminBean : l1) {
			if (adminid.equals(adminBean.getAdminId()) && password.equals(adminBean.getAPass())) {
				return true;
			}
		}
		throw new AdminExceptions("Invalid Admin");
	}
	

}
