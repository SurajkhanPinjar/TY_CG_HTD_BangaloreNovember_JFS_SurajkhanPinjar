package com.capgemini.forestry.dao;

import java.util.ArrayList;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.CustomerBean;

public interface CustomerDao {
	public boolean addCustomer(CustomerBean bean);
	public boolean deleteCustomer(int customerid, long telephone);
	public boolean modifyCustomer(int customerid);
	public ArrayList<CustomerBean> getCustomer(int customerid, long telephone);
	public ArrayList<CustomerBean> getAllCust();

}
