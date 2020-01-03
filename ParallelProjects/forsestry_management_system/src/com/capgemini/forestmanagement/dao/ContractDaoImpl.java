package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ContractBean;
import com.capgemini.forestmanagement.exception.ContractsExceptions;

public class ContractDaoImpl implements ContractDao {
	
	private List<ContractBean> acontract= new ArrayList<ContractBean>();
	ContractBean bean= new ContractBean();
	Scanner sc=new Scanner(System.in);

	@Override
	public boolean addContract(ContractBean contract) {
		for (ContractBean contractBean : acontract) {
			if(contractBean.getCustomerId() == contract.getCustomerId()) {
				throw new ContractsExceptions("Contracts Cannot be Added\nContract Id Already Existed");
			}
		}
		acontract.add(contract);
		return true;
		
	}
	

	@Override
	public boolean deleteContract(int prodid) {
		for (ContractBean contractBean : acontract) {
			if(contractBean.getCustomerId() == prodid) {
				acontract.remove(contractBean);
				return true;
			} 
		}
		throw new ContractsExceptions("Contract Cannot be Deleted\nEnter Valid Contract Id");
	}

	@Override
	public List<ContractBean> showContract(ContractBean contract) {
		for (ContractBean contractBean : acontract) {
			if (contractBean != null) {
				return acontract;
			}
		}
		throw new ContractsExceptions("Contract Cannot be Found\nEnter Valid Contract Ids");
	}


	@Override
	public List<ContractBean> showAllContract() {
		if (acontract!= null) {
			return acontract;
		} 
		throw new ContractsExceptions("No Contract Present");
		
	}
	

}
