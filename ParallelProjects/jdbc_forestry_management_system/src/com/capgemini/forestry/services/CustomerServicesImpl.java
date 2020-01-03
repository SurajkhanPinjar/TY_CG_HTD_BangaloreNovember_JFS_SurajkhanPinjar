package com.capgemini.forestry.services;

import java.util.ArrayList;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.dao.CustomerDao;
import com.capgemini.forestry.factory.Factory;

public class CustomerServicesImpl implements CustomerServices {
	CustomerDao dao = Factory.getCustDao();
	@Override
	public boolean addCustomer(CustomerBean bean) {
		// TODO Auto-generated method stub
		return dao.addCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int customerid, long telephone) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerid, telephone);
	}

	@Override
	public boolean modifyCustomer(int customerid) {
		// TODO Auto-generated method stub
		return dao.modifyCustomer(customerid);
	}

	@Override
	public ArrayList<CustomerBean> getCustomer(int customerid, long telephone) {
		// TODO Auto-generated method stub
		return dao.getCustomer(customerid, telephone);
	}

	@Override
	public ArrayList<CustomerBean> getAllCust() {
		// TODO Auto-generated method stub
		return dao.getAllCust();
	}

}
