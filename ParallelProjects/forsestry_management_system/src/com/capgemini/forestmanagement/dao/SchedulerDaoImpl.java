package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.bean.AdminBean;
import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.SchedulerBean;
import com.capgemini.forestmanagement.exception.SchedulerExceptions;

public class SchedulerDaoImpl implements SchedulerDao {

	private List<SchedulerBean> l1 = new ArrayList<SchedulerBean>();
	SchedulerBean b = new SchedulerBean();
	
	@Override
	public boolean addScheduler(SchedulerBean sbean) {
		for (SchedulerBean schedulerBean : l1) {
			if(sbean.getSchedId() == schedulerBean.getSchedId()) {
				System.err.println("Scheduler Id Already Existed :( ");
				throw new SchedulerExceptions("Scheduler Account Cannot be added\nScheduler Id Already Existed");
			}
			
		}
		l1.add(sbean);
		return true;
	}

	@Override
	public boolean deleteScheduler(int schedid, String schedpassword) {
		for (SchedulerBean schedulerBean: l1) {
			if((schedulerBean.getSchedId()) == schedid || schedpassword == schedulerBean.getSchedPassword()) {
				l1.remove(schedulerBean);
				return true;
			}
		}
		throw new SchedulerExceptions("Scheduler Cannot be Added\nEnter Valid Scheduler Id");
	}

	@Override
	public boolean updateScheduler(int schedid, String schedpassword) {
		return false;
	}

	@Override
	public List<SchedulerBean> searchScheduler(int Schedid) {
		for (SchedulerBean schedulerBean : l1) {
			if(schedulerBean.getSchedId() == Schedid) {
				return l1;
			}
		}
		throw new SchedulerExceptions("Scheduler Cannot be Found\nEnter Valid Scheduler Id");
	}

	@Override
	public boolean loginScheduler(Object schedid, String schedpassword) {
		for (SchedulerBean schedulerBean : l1) {
			System.out.println(schedulerBean.getSchedId());
			if(schedid.equals(schedulerBean.getSchedId()) && schedpassword.equals(schedulerBean.getSchedPassword())) {
					return true;
				}
			}
		throw new SchedulerExceptions("Login Failed\nEnter Valid Scheduler Id");
	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		if (l1!= null) {
			return l1;
		} 
		throw new SchedulerExceptions("No Scheduler Present");
	}
	

}
