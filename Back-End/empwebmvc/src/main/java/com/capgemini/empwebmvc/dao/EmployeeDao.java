package com.capgemini.empwebmvc.dao;

import java.util.List;

import com.capgemini.empwebmvc.beans.EmployeeBean;

public interface EmployeeDao {
	public EmployeeBean auth(String email, String password);
	public boolean register(EmployeeBean bean);
	public List<EmployeeBean>  getEmployee(String key);
	public boolean changePassword(int id, String password);
}
