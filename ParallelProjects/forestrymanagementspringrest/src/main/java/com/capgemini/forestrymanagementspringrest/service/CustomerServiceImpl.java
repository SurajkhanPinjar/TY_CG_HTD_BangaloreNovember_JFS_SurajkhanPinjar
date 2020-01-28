package com.capgemini.forestrymanagementspringrest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringrest.dao.CustomerDao;
import com.capgemini.forestrymanagementspringrest.dto.Customer;
import com.capgemini.forestrymanagementspringrest.exception.CustomerExceptions;
import com.capgemini.forestrymanagementspringrest.validation.Validation;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao ; 

	@Override
	public boolean addCustomer(Customer customer) {
		String customerName = customer.getCustomerName();
		if (Validation.isStringOnlyAlphabet(customerName)) {
			customer.setCustomerName(customerName);
		} else {
			throw new CustomerExceptions("Enter Only Alphabates In Customer Name Field.");
		}
		
		String town = customer.getTown();
		if (Validation.isStringOnlyAlphabet(town)) {
			customer.setTown(town);
		} else {
			throw new CustomerExceptions("Enter Only Alphabates In Town Field.");
		}
		
		String email = customer.getEmail();
		if (Validation.isValidEmail(email)) {
			customer.setEmail(email);
		} else {
			throw new CustomerExceptions("Enter Valid Email Id in Email Field(i.e. abc@g.com).");
		}
		
		customer.setTelephone(customer.getTelephone());
		
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	public ArrayList<Customer> getAllCust() {
		return customerDao.getAllCust();
	}

	@Override
	public boolean modifyCustomer(Customer customer) {
		
		String customerName = customer.getCustomerName();
		if (Validation.isStringOnlyAlphabet(customerName)) {
			customer.setCustomerName(customerName);
		} else {
			throw new CustomerExceptions("Enter Only Alphabates In Customer Name Field.");
		}
		
		String town = customer.getTown();
		if (Validation.isStringOnlyAlphabet(town)) {
			customer.setTown(town);
		} else {
			throw new CustomerExceptions("Enter Only Alphabates In Town Field.");
		}
		
		String email = customer.getEmail();
		if (Validation.isValidEmail(email)) {
			customer.setEmail(email);
		} else {
			throw new CustomerExceptions("Enter Valid Email Id in Email Field(i.e. abc@g.com).");
		}
		
		

		
		return customerDao.modifyCustomer(customer);
	}

	 
}
