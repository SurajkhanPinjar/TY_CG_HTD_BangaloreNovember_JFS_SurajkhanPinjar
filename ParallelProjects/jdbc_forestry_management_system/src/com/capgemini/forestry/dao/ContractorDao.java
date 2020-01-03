package com.capgemini.forestry.dao;

import java.util.ArrayList;

import com.capgemini.forestry.bean.ContractorBean;

public interface ContractorDao {
	public boolean addContractor(ContractorBean contractor);
	public boolean deleteContractor(int contractid);
	public ArrayList<ContractorBean> getContractor(int contractno);
	public ArrayList<ContractorBean> getAllContractor();
	public boolean modifyContractor(int contractNo);
}
