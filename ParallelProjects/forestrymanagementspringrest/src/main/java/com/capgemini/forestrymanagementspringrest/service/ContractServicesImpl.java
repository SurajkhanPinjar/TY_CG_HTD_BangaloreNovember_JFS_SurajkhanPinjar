package com.capgemini.forestrymanagementspringrest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringrest.dao.ContractDao;
import com.capgemini.forestrymanagementspringrest.dao.CustomerDao;
import com.capgemini.forestrymanagementspringrest.dao.ProductDao;
import com.capgemini.forestrymanagementspringrest.dto.Contracts;
import com.capgemini.forestrymanagementspringrest.exception.ContractsExceptions;
import com.capgemini.forestrymanagementspringrest.validation.Validation;

@Service
public class ContractServicesImpl implements ContractServices {
	@Autowired
	private ContractDao contractDao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ProductDao ProductDao;
	
	@Override
	public boolean addContract(Contracts contracts) {
		
		contracts.setDeliveryDate("Not Scheduled");
		contracts.setStatus("pending");
		
		
		if (ProductDao.getProduct(contracts.getProdId()) == null || 
				customerDao.getCustomer(contracts.getCustomerId()) == null) {
			
		}
		return contractDao.addContract(contracts);
	}

	@Override
	public boolean deleteContract(int contractId) {
		return contractDao.deleteContract(contractId);
	}

	@Override
	public Contracts getContract(int contractNo) {
		return contractDao.getContract(contractNo);
	}

	@Override
	public ArrayList<Contracts> getAllContract() {
		return contractDao.getAllContract();
	}

	@Override
	public boolean scheduleContracts(Contracts contract) {

		
		String deliveryDate = contract.getDeliveryDate();
		if (Validation.isValidDat(deliveryDate)) {
			contract.setDeliveryDate(deliveryDate);
		} else {
			throw new ContractsExceptions("Enter valid Date.(Enter only future Dates)");
		}
		
		String status = contract.getStatus();
		if (Validation.isStringOnlyAlphabet(status)) {
			contract.setStatus(status);
		} else {
			throw new ContractsExceptions("Enter Only Alphabates");
		}
		
		return contractDao.scheduleContracts(contract);
	}

	@Override
	public boolean modifyContracts(Contracts contract) {
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		
		
		if (ProductDao.getProduct(contract.getProdId()) == null || 
				customerDao.getCustomer(contract.getCustomerId()) == null) {
			
		}
		
		return contractDao.scheduleContracts(contract);
	}
	
	

}
