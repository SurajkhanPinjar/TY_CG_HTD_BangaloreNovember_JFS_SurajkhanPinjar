package com.capgemini.forestrymanagementspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.capgemini.forestrymanagementspringboot.dao.LandDao;
import com.capgemini.forestrymanagementspringboot.dto.Land;
import com.capgemini.forestrymanagementspringboot.exception.CustomerExceptions;
import com.capgemini.forestrymanagementspringboot.validation.Validation;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@Service
public class LandServicesImpl implements LandServices {
	
	@Autowired
	private LandDao landDao ;

	@Override
	public boolean addLand(Land land) {
		String landLocation = land.getLocation();
		if (Validation.isStringOnlyAlphabet(landLocation)) {
			land.setLocation(landLocation); 
		} else {
			throw new CustomerExceptions("Enter Only Alphabates In Land Location Field.");
		}
		
		String owner = land.getOwnerName();
		if (Validation.isStringOnlyAlphabet(owner)) {
			land.setOwnerName(owner);; 
		} else {
			throw new CustomerExceptions("Enter Only Alphabates In land Owner name Field.");
		}
		
		String acquiredDate = land.getDate();
		if (Validation.isValidDate(acquiredDate)) {
			land.setOwnerName(acquiredDate);; 
		} else {
			throw new CustomerExceptions("Enter Only Future dates in Date Field.");
		}
		
		
		
		return landDao.addLand(land);
	}

	@Override
	public boolean deleteLand(int landId) {
		return landDao.deleteLand(landId);
	}


	@Override
	public Land searchLand(int landId) {
		return landDao.searchLand(landId);
	}

	@Override
	public List<Land> getAllLand() {
		return landDao.getAllLand();
	}

	@Override
	public boolean modifyLand(Land land) {
		return landDao.modifyLand(land);
	}

}
