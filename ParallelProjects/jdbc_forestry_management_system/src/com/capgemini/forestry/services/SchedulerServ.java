package com.capgemini.forestry.services;

import java.util.List;

import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.bean.SchedulerBean;

public interface SchedulerServ {

	public boolean addScheduler(SchedulerBean sbean);
	public boolean deleteScheduler(int schedulerId, String password );
	public boolean loginScheduler(int schedulerId, String password);
	public List<SchedulerBean> getAllScheduler();
}
