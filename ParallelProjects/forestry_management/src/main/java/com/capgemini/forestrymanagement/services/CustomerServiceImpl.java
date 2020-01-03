package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestrymanagement.dao.CustomerDao;
import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.factory.Factory;

public class CustomerServiceImpl implements CustomerService{

	
	CustomerDao dao = Factory.getCustomerDaoImpl();
	@Override
	public boolean addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return dao.addCustomer(c);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

	

	@Override
	public List<Customer> getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return (List<Customer>) dao.getCustomer(customerId);
	}

	@Override
	public ArrayList<Customer> getAllCust() {
		// TODO Auto-generated method stub
		return dao.getAllCust();
	}

	@Override
	public boolean modifyCustomer(int customerId, String customerName) {
		// TODO Auto-generated method stub
		return dao.modifyCustomer(customerId, customerName);
	}

	@Override
	public boolean modifyCustomerAdd1(int customerId, String address1) {
		// TODO Auto-generated method stub
		return dao.modifyCustomerAdd1(customerId, address1);
	}

	@Override
	public boolean modifyCustomerAdd2(int customerId, String address2) {
		// TODO Auto-generated method stub
		return dao.modifyCustomerAdd2(customerId, address2);
	}

	@Override
	public boolean modifyCustomerTown(int customerId, String town) {
		// TODO Auto-generated method stub
		return dao.modifyCustomerTown(customerId, town);
	}

	@Override
	public boolean modifyCustomerEmail(int customerId, String emailId) {
		// TODO Auto-generated method stub
		return dao.modifyCustomerEmail(customerId, emailId);
	}

	@Override
	public boolean modifyCustomerPost(int customerId, int postCode) {
		// TODO Auto-generated method stub
		return dao.modifyCustomerPost(customerId, postCode);
	}

	@Override
	public boolean modifyCustomerTel(int customerId, long telephone) {
		// TODO Auto-generated method stub
		return dao.modifyCustomerTel(customerId, telephone);
	}

}
