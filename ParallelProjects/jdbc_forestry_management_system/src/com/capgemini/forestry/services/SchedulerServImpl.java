package com.capgemini.forestry.services;

import java.util.List;

import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.bean.SchedulerBean;
import com.capgemini.forestry.dao.SchedulerDao;
import com.capgemini.forestry.factory.Factory1;

public class SchedulerServImpl implements SchedulerServ {
	SchedulerDao dao = Factory1.getSchedDao();
	@Override
	public boolean addScheduler(SchedulerBean sbean) {
		// TODO Auto-generated method stub
		return dao.addScheduler(sbean);
	}

	@Override
	public boolean deleteScheduler(int schedulerId, String password) {
		// TODO Auto-generated method stub
		return dao.deleteScheduler(schedulerId, password);
	}

	@Override
	public boolean loginScheduler(int schedulerId, String password) {
		// TODO Auto-generated method stub
		return dao.loginScheduler(schedulerId, password);
	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		// TODO Auto-generated method stub
		return dao.getAllScheduler();
	}
	

}
