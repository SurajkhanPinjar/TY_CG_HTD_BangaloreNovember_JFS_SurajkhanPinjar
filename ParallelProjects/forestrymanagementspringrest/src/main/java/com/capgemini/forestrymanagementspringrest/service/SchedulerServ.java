package com.capgemini.forestrymanagementspringrest.service;

import java.util.List;

import com.capgemini.forestrymanagementspringrest.dto.Scheduler;

public interface SchedulerServ {

	public boolean addScheduler(Scheduler scheduler);

	public boolean deleteScheduler(int schedulerId);

	public Scheduler login(Scheduler scheduler);

	public List<Scheduler> getAllScheduler();

	public Scheduler searchScheduler(int schedulerId);

	public boolean modifyScheduler(int schedulerId, String schedulerName);

	public boolean modifySchedulerPass(int schedulerId, String SchedulerPassword);
}
