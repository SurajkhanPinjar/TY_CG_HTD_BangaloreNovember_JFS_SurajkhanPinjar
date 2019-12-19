package com.capgemini.myweb.dao;

import java.util.List;

import com.capgemini.myweb.beans.EmployeeInfoBean;

public interface EmployeeDao {

	public EmployeeInfoBean authenticate(int empId, String password );
	public EmployeeInfoBean searchEmployee(int empId);
	
	public boolean addEmployee(EmployeeInfoBean empBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean empBean);
	public List<EmployeeInfoBean>  getAllEmployees();
	
}// End of Dao

