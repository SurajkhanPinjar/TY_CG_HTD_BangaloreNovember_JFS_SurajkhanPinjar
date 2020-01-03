package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.ContractBean;

public interface ContractDao {
	
	public boolean addContract (ContractBean contract);
	public boolean deleteContract(int prodid);
	public List<ContractBean> showContract(ContractBean contract);
	public List<ContractBean> showAllContract();
	
}



