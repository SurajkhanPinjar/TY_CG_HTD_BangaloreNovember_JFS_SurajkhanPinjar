package com.capgemini.myweb.service;

import java.util.List;

import com.capgemini.myweb.beans.EmployeeInfoBean;

public interface EmployeeService {

	public EmployeeInfoBean searchEmployee(int empId);
	public EmployeeInfoBean authenticate(int empId, String password );
	
	public boolean addEmployee(EmployeeInfoBean empBean);
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(EmployeeInfoBean empBean);
	public List<EmployeeInfoBean>  getAllEmployees();
}// Employee Of DAO
