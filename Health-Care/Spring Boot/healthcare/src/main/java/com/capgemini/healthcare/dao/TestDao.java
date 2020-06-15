package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.Test;

public interface TestDao {
	public boolean addTest(Test test);

	public boolean removeTest(String centerId);

	public boolean updateTest(Test Test);

	public Test searchTest(int testId);

	public List<Test> getAllTest();
	
	public List<Test> getAllTestCenter(String centerId);

}
