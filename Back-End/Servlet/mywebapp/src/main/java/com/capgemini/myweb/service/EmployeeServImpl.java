package com.capgemini.myweb.service;

import java.util.List;

import com.capgemini.myweb.beans.EmployeeInfoBean;
import com.capgemini.myweb.dao.EmployeeDao;
import com.capgemini.myweb.dao.EmployeeDaoImpl;

public class EmployeeServImpl implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
		return dao.searchEmployee(empId);
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(empId, password);
	}

	
	public boolean addEmployee(EmployeeInfoBean empBean) {
		// TODO Auto-generated method stub
		return dao.addEmployee(empBean);
	}

	

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean empBean) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(empBean);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

}
