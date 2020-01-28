package com.capgemini.forestrymanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementspringrest.dto.Land;
import com.capgemini.forestrymanagementspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = {TestBeans.class, ORMConfig.class })
class LandDaoTest {

	@Autowired
	LandDao landDao;
	
	@Test
	void testAddLand() {
		Land land = new Land();
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		assertTrue(landDao.addLand(land));
		landDao.deleteLand(786);
		
	}

	@Test
	void testDeleteLand() {
		Land land = new Land();
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		landDao.addLand(land);
		assertTrue(landDao.deleteLand(786));
	}


	@Test
	void testSearchLand() {
		Land land = new Land();
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		landDao.addLand(land);
		assertNotNull(landDao.searchLand(786));
		landDao.deleteLand(786);
	}

	@Test
	void testGetAllLand() {
		assertNotNull(landDao.getAllLand());
	}

}
