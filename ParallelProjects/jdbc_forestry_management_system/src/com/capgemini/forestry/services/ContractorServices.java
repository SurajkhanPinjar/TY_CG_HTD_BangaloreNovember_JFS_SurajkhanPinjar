package com.capgemini.forestry.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestry.bean.ContractorBean;


public interface ContractorServices {
	
	public boolean addContractor(ContractorBean contractor);
	public boolean deleteContractor(int contractid);
	public ArrayList<ContractorBean> getContractor(int contractno);
	public ArrayList<ContractorBean> getAllContractor();
	public boolean modifyContractor(int contractNo);
	
}
