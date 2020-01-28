package com.capgemini.forestrymanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementspringrest.dto.Contracts;
import com.capgemini.forestrymanagementspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = {TestBeans.class, ORMConfig.class})
class ContractDaoTest {

	@Autowired
	ContractDao contractDao;
	
	
	@Test
	void testAddContract() {
		Contracts contract = new Contracts();
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProdId(30);
		contract.setQuantity("10");
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		assertTrue(contractDao.addContract(contract));
		contractDao.deleteContract(786);
	}

	@Test
	void testDeleteContract() {
		Contracts contract = new Contracts();
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProdId(30);
		contract.setQuantity("10");
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		contractDao.addContract(contract);
		assertTrue(contractDao.deleteContract(786));
	}

	@Test
	void testGetContract() {
		Contracts contract = new Contracts();
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProdId(30);
		contract.setQuantity("10");
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		contractDao.addContract(contract);
		assertNotNull(contractDao.getContract(786));
		contractDao.deleteContract(786);
	}

	@Test
	void testGetAllContract() {
		assertNotNull(contractDao.getAllContract());
	}

	@Test
	void testScheduleContracts() {
		Contracts contract = new Contracts();
		contract.setContractNo(786);
		contract.setCustomerId(20);
		contract.setProdId(30);
		contract.setQuantity("10");
		contract.setDeliveryDate("Not Scheduled");
		contract.setStatus("pending");
		contractDao.addContract(contract);
		contract.setDeliveryDate("Scheduled");
		contract.setStatus("Approve");
		assertTrue(contractDao.scheduleContracts(contract));
		contractDao.deleteContract(786);
	}

}
