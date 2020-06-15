package com.capgemini.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.Test;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public boolean addTest(Test test) {
		return testDao.addTest(test);
	}

	@Override
	public boolean removeTest(String centerId) {
		return testDao.removeTest(centerId);
	}

	@Override
	public boolean updateTest(Test Test) {
		return testDao.updateTest(Test);
	}

	@Override
	public Test searchTest(int testId) {
		return testDao.searchTest(testId);
	}

	@Override
	public List<Test> getAllTest() {
		return testDao.getAllTest();
	}

	@Override
	public List<Test> getAllTestCenter(String centerId) {
		return testDao.getAllTestCenter(centerId);
	}

}
