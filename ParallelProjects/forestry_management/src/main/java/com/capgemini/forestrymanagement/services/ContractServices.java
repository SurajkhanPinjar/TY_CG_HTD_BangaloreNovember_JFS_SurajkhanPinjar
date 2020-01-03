package com.capgemini.forestrymanagement.services;

import java.util.ArrayList;

import com.capgemini.forestrymanagement.dto.Contracts;

public interface ContractServices {
	
	public boolean addContract(Contracts c);
	public boolean deleteContract(int contractId);
	public Contracts getContract(int contractNo);
	public ArrayList<Contracts> getAllContract();
	

}
