package com.capgemini.forestry.factory;

import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.bean.SchedulerBean;
import com.capgemini.forestry.dao.ClientDao;
import com.capgemini.forestry.dao.ClientDaoImpl;
import com.capgemini.forestry.dao.LandDao;
import com.capgemini.forestry.dao.LandDaoImpl;
import com.capgemini.forestry.dao.SchedulerDao;
import com.capgemini.forestry.dao.SchedulerDaoImpl;
import com.capgemini.forestry.services.ClientServicesImpl;
import com.capgemini.forestry.services.ClientSevices;
import com.capgemini.forestry.services.LandServices;
import com.capgemini.forestry.services.LandServicesImpl;
import com.capgemini.forestry.services.SchedulerServ;
import com.capgemini.forestry.services.SchedulerServImpl;

public class Factory1 {
	private Factory1() {
		
	}
	
	public static ClientBean getClBean() {
	ClientBean bean = new ClientBean();
	return bean;
	}
	
	public static ClientSevices getClServ() {
		ClientSevices serv = new ClientServicesImpl();
		return serv;
		
	}
	
	public static ClientDao getClDao() {
		ClientDao dao = new ClientDaoImpl();
		return dao;
	}
	
	public static LandDao getLandDaoImpl() {
		return new LandDaoImpl();
	}
	
	public static LandServices getLandServImpl( ) {
		return new LandServicesImpl();
	}
	
	public static LandBean getLandBean() {
		return new LandBean();
	}
	
	public static SchedulerServ getScheduServ() {
		return (SchedulerServ) new SchedulerServImpl();
	}
	
	public static SchedulerDao getSchedDao() {
		return (SchedulerDao) new SchedulerDaoImpl();
	}
 
	public static SchedulerBean getSchedBean() {
		return new SchedulerBean();
	}
	
}
