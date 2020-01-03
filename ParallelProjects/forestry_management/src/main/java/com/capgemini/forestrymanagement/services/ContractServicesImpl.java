package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dao.ContractDao;
import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.factory.Factory;

public class ContractServicesImpl implements ContractServices{
	
	ContractDao dao = Factory.getContractDaoImpl();
	
	@Override
	public boolean addContract(Contracts c) {
		// TODO Auto-generated method stub
		return dao.addContract(c);
	}

	@Override
	public boolean deleteContract(int contractId) {
		// TODO Auto-generated method stub
		return dao.deleteContract(contractId);
	}

	@Override
	public Contracts getContract(int contractNo) {
		// TODO Auto-generated method stub
		return dao.getContract(contractNo);
	}

	@Override
	public ArrayList<Contracts> getAllContract() {
		// TODO Auto-generated method stub
		return dao.getAllContract();
	}

}
