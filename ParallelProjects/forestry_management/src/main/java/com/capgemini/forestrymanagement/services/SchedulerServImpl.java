package com.capgemini.forestrymanagement.services;

import java.util.List;

import com.capgemini.forestrymanagement.dao.SchedulerDao;
import com.capgemini.forestrymanagement.dto.Scheduler;
import com.capgemini.forestrymanagement.factory.Factory;

public class SchedulerServImpl implements SchedulerServ {
	SchedulerDao dao = Factory.getSchedulerDao();
	
	@Override
	public boolean addScheduler(Scheduler scheduler) {
		return dao.addScheduler(scheduler);
	}

	@Override
	public boolean deleteScheduler(int schedulerId) {
		return dao.deleteScheduler(schedulerId);
	}

	@Override
	public boolean loginScheduler(int schedulerId, String schedulerPassword) {
		return dao.loginScheduler(schedulerId, schedulerPassword);
	}

	@Override
	public List<Scheduler> getAllScheduler() {
		return dao.getAllScheduler();
	}

	@Override
	public List<Scheduler> searchScheduler(int schedulerId) {
		return dao.searchScheduler(schedulerId);
	}


	@Override
	public boolean modifyScheduler(int schedulerId, String schedulerName) {
		return dao.modifyScheduler(schedulerId, schedulerName);
	}

	@Override
	public boolean modifySchedulerPass(int schedulerId, String SchedulerPassword) {
		// TODO Auto-generated method stub
		return dao.modifySchedulerPass(schedulerId, SchedulerPassword);
	}
	
	

}
