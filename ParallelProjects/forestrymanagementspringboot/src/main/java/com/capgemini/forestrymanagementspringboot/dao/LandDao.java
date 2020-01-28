package com.capgemini.forestrymanagementspringboot.dao;

import java.util.List;

import com.capgemini.forestrymanagementspringboot.dto.Land;

public interface LandDao {
	public boolean addLand(Land land);

	public boolean deleteLand(int landId);

	public boolean modifyLand(Land land);

	public Land searchLand(int landId);

	public List<Land> getAllLand();

}
