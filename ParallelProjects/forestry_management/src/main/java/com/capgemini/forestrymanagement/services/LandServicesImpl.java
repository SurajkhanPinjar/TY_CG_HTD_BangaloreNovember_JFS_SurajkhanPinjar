package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dao.LandDao;
import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.factory.Factory;

public class LandServicesImpl implements LandServices {
	LandDao dao = Factory.getLandDao();
	
	@Override
	public boolean addLand(Land land) {
		return dao.addLand(land);
	}

	@Override
	public boolean deleteLand(int landId) {
		
		return dao.deleteLand(landId);
	}

	@Override
	public boolean modifyLand(int landId) {

		return dao.modifyLand(landId);
	}

	@Override
	public List<Land> searchLand(int landId) {

		return dao.searchLand(landId);
	}

	@Override
	public List<Land> getAllLand() {
		return dao.getAllLand();
	}


}
