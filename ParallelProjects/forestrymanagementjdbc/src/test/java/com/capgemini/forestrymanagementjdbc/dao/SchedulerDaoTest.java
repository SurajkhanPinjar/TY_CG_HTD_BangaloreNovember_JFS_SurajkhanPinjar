package com.capgemini.forestrymanagementjdbc.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;

class SchedulerDaoTest {

	private static SchedulerDao schedulerDao = new SchedulerDaoImpl();
	private static SchedulerBean scheduler = new SchedulerBean();
	
	@BeforeAll
	static void addScheduler() {
		scheduler.setSchedulerName("azad");
		scheduler.setSchedulerId(786);
		scheduler.setSchedulerPassword("asdf");
		scheduler.setRole("scheduler");
		schedulerDao.addScheduler(scheduler);
	}
	
	@AfterAll
	static void delete() {
		schedulerDao.deleteScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword());
	}

	@Test
	void testLoginScheduler() {
		assertTrue(schedulerDao.loginScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword()));
	}

	@Test
	void testGetAllScheduler() {
		assertNotNull(schedulerDao.getAllScheduler());
	}

	@Test
	void testAddScheduler() {
	}
	
	@Test
	void testDeleteScheduler() {
		
	}
	
}
