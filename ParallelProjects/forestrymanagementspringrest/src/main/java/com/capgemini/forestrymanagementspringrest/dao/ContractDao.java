package com.capgemini.forestrymanagementspringrest.dao;

import java.util.ArrayList;

import com.capgemini.forestrymanagementspringrest.dto.Contracts;

public interface ContractDao {
	public boolean addContract(Contracts c);

	public boolean deleteContract(int contractNo);

	public Contracts getContract(int contractNo);

	public ArrayList<Contracts> getAllContract();

	public boolean scheduleContracts(Contracts contract);
}
