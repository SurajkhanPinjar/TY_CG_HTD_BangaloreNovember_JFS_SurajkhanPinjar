package com.capgemini.forestry.services;

import java.util.ArrayList;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.CustomerBean;

public interface CustomerServices {
	public boolean addCustomer(CustomerBean bean);
	public boolean deleteCustomer(int customerid, long telephone);
	public boolean modifyCustomer(int customerid);
	public ArrayList<CustomerBean> getCustomer(int customerid, long telephone);
	public ArrayList<CustomerBean> getAllCust();
}
