package com.capgemini.forestry.dao;

import java.util.List;

import com.capgemini.forestry.bean.LandBean;

public interface LandDao {
	public boolean addLand(LandBean lbean);
	public boolean deleteLand(int landid );
	public boolean modifyLand(int landid);
	public List<LandBean> searchLand(int landid);
	public List<LandBean> getAllLand();

}