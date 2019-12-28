package com.capgemini.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springrest.dao.EmployeeDao;
import com.capgemini.springrest.dto.EmployeeAddressBean;
import com.capgemini.springrest.dto.EmployeeBean;


@Service				//since it is a Service Layer
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;		//just like Factory

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		//Encrypting The Password
	
	@Override
	public EmployeeBean auth(String email, String password) {
		
		return dao.auth(email, password);		//encode the passsword
	}

	@Override
	public boolean register(EmployeeBean bean) {				//impo step to insert data in db
		String encodePassword = encoder.encode(bean.getPassword());
		bean.setPassword(encodePassword);
		
		List<EmployeeAddressBean > addeAddressBeans = bean.getAddressBeans();
		for (EmployeeAddressBean employeeAddressBean : addeAddressBeans) {
			employeeAddressBean.setBean(bean);
		}
		return dao.register(bean);
	}

	@Override
	
	public List<EmployeeBean> getEmployee(String key) {
		return dao.getEmployee(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		return dao.changePassword(id, password);			//Encryption 
	}

	@Override
	public boolean deleteEmp(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(id);
	}

}
