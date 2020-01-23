package com.capgemini.forestrymanagementspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementspringrest.dao.SchedulerDao;
import com.capgemini.forestrymanagementspringrest.dto.Scheduler;

@Service
public class SchedulerServImpl implements SchedulerServ {
	@Autowired
	SchedulerDao schedulerDao;

	@Override
	public boolean addScheduler(Scheduler scheduler) {
		return schedulerDao.addScheduler(scheduler);
	}

	@Override
	public boolean deleteScheduler(int schedulerId) {
		return schedulerDao.deleteScheduler(schedulerId);
	}

	@Override
	public List<Scheduler> getAllScheduler() {
		return schedulerDao.getAllScheduler();
	}

	@Override
	public Scheduler searchScheduler(int schedulerId) {
		return schedulerDao.searchScheduler(schedulerId);
	}

	@Override
	public boolean modifyScheduler(int schedulerId, String schedulerName) {
		return schedulerDao.modifyScheduler(schedulerId, schedulerName);
	}

	@Override
	public boolean modifySchedulerPass(int schedulerId, String SchedulerPassword) {
		return schedulerDao.modifySchedulerPass(schedulerId, SchedulerPassword);
	}

	@Override
	public Scheduler login(Scheduler scheduler) {
		return schedulerDao.login(scheduler);
	}

}
