package com.capgemini.empspringboots.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.empspringboots.dto.EmployeeAddressBean;
import com.capgemini.empspringboots.dto.EmployeeBean;
import com.capgemini.empspringboots.exception.EmployeeException;
import com.capgemini.empspringboots.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public EmployeeBean auth(String email, String password) {
		EmployeeBean bean = repository.findByEmail(email);
		if (bean!= null) {
		if (encoder.matches(password, bean.getPassword())) {
			return bean;
			
		}
		throw new EmployeeException("Password not Matches");
		}
		throw new EmployeeException("Email does't exist");
	}

	@Override
	public boolean register(EmployeeBean bean) {
		bean.setPassword(encoder.encode(bean.getPassword()));
		for (EmployeeAddressBean addressBean : bean.getAddressBeans()) {
			addressBean.setBean(bean);
		}
		repository.save(bean);
		
		return true;
	}

	@Override
	public List<EmployeeBean> getEmployee(String key) {
		return repository.findByKey(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		repository.changePassword(id, encoder.encode(password));
		return true;
	}

	@Override
	public boolean deleteEmp(int id) {
		repository.deleteById(id);
		return true;
	}

}
