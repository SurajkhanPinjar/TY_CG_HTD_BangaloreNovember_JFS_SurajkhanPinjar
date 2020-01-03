package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.CustomerBean;

public interface CustomerDao {
	public boolean addCustomer(CustomerBean bean);
	public boolean deleteCustomer(int custId);
	public boolean modifyCustomer(int custId);
	public List<CustomerBean> showAllCustomer(CustomerBean bean);
	public List<CustomerBean> searchCustomer(int custId);
}



