package com.capgemini.forestry.services;

import java.util.List;

import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.dao.LandDao;
import com.capgemini.forestry.factory.Factory1;

public class LandServicesImpl implements LandServices {

	LandDao dao = Factory1.getLandDaoImpl();
	
	@Override
	public boolean addLand(LandBean lbean) {
		// TODO Auto-generated method stub
		return dao.addLand(lbean);
	}

	@Override
	public boolean deleteLand(int landid) {
		return dao.deleteLand(landid);
	}

	@Override
	public boolean modifyLand(int landid) {
		return dao.modifyLand(landid);
	}

	@Override
	public List<LandBean> searchLand(int landid) {
		return dao.searchLand(landid);
	}

	@Override
	public List<LandBean> getAllLand() {
		return dao.getAllLand();
	}

}
