package com.capgemini.forestrymanagementspringboot.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestrymanagementspringboot.dao.LandDao;
import com.capgemini.forestrymanagementspringboot.dto.Land;

@SpringBootTest
class LandServicesTest {

	@Autowired
	LandServices landServices;
	
	@Test
	void testAddLand() {
		Land land = new Land();
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		assertTrue(landServices.addLand(land));
		landServices.deleteLand(786);
		
	}

	@Test
	void testDeleteLand() {
		Land land = new Land();
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		landServices.addLand(land);
		assertTrue(landServices.deleteLand(786));
	}


	@Test
	void testSearchLand() {
		Land land = new Land();
		land.setLandId(786);
		land.setDate("12/22/2020");
		land.setLocation("kabbur");
		land.setOwnerName("azad");
		land.setValue(10000);
		landServices.addLand(land);
		assertNotNull(landServices.searchLand(786));
		landServices.deleteLand(786);
	}

	@Test
	void testGetAllLand() {
		assertNotNull(landServices.getAllLand());
	}

}
