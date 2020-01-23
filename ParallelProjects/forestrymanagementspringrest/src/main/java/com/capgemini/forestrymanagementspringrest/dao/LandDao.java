package com.capgemini.forestrymanagementspringrest.dao;

import java.util.List;

import com.capgemini.forestrymanagementspringrest.dto.Land;

public interface LandDao {
	public boolean addLand(Land land);

	public boolean deleteLand(int landId);

	public boolean modifyLand(int landId);

	public Land searchLand(int landId);

	public List<Land> getAllLand();

}
