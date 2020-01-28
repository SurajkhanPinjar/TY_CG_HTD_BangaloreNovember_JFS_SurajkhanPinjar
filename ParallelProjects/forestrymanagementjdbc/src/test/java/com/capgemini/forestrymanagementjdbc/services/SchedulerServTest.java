package com.capgemini.forestrymanagementjdbc.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestrymanagementjdbc.bean.SchedulerBean;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDao;
import com.capgemini.forestrymanagementjdbc.dao.SchedulerDaoImpl;

class SchedulerServTest {

	private static SchedulerServ schedulerServices = new SchedulerServImpl();
	private static SchedulerBean scheduler = new SchedulerBean();
	
	@BeforeAll
	static void addScheduler() {
		scheduler.setSchedulerName("azad");
		scheduler.setSchedulerId(786);
		scheduler.setSchedulerPassword("asdf");
		scheduler.setRole("scheduler");
		schedulerServices.addScheduler(scheduler);
	}
	
	@AfterAll
	static void delete() {
		schedulerServices.deleteScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword());
	}

	@Test
	void testLoginScheduler() {
		assertTrue(schedulerServices.loginScheduler(scheduler.getSchedulerId(), scheduler.getSchedulerPassword()));
	}

	@Test
	void testGetAllScheduler() {
		assertNotNull(schedulerServices.getAllScheduler());
	}

	@Test
	void testAddScheduler() {
	}
	
	@Test
	void testDeleteScheduler() {
		
	}

}
