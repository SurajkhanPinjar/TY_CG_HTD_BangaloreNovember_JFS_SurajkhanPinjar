package com.capgemini.forestry.services;

import java.util.ArrayList;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.dao.ContractorDao;
import com.capgemini.forestry.factory.Factory;

public class ContractorServiceImpl implements ContractorServices {

	ContractorDao dao = Factory.getContrDao();	
	@Override
	public boolean addContractor(ContractorBean contractor) {
		return dao.addContractor(contractor);
	}

	@Override
	public boolean deleteContractor(int contractid) {
		// TODO Auto-generated method stub
		return dao.deleteContractor(contractid);
	}

	@Override
	public ArrayList<ContractorBean> getContractor(int contractno) {
		return dao.getContractor(contractno);
	}

	@Override
	public ArrayList<ContractorBean> getAllContractor() {
		// TODO Auto-generated method stub
		return dao.getAllContractor();
	}

	@Override
	public boolean modifyContractor(int contractNo) {
		return dao.modifyContractor(contractNo);
	}

}
