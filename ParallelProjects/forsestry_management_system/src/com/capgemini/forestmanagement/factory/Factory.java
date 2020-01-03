package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.bean.AdminBean;
import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.dao.AdminDao;
import com.capgemini.forestmanagement.dao.AdminDaoImpl;
import com.capgemini.forestmanagement.dao.ClientDao;
import com.capgemini.forestmanagement.dao.ClientDaoImpl;
import com.capgemini.forestmanagement.dao.ContractDao;
import com.capgemini.forestmanagement.dao.ContractDaoImpl;
import com.capgemini.forestmanagement.dao.CustomerDao;
import com.capgemini.forestmanagement.dao.CustomerDaoImpl;
import com.capgemini.forestmanagement.dao.LandDao;
import com.capgemini.forestmanagement.dao.LandDaoImpl;
import com.capgemini.forestmanagement.dao.ProductDao;
import com.capgemini.forestmanagement.dao.ProductDaoImpl;
import com.capgemini.forestmanagement.dao.SchedulerDao;
import com.capgemini.forestmanagement.dao.SchedulerDaoImpl;

public class Factory {
	private Factory() {
		
	}
	
	public static ContractDao objDao() {
		ContractDao dao=new ContractDaoImpl();
		return dao;
	}
	
	public static CustomerDao cstDao() {
		CustomerDao dao1=new CustomerDaoImpl();
		return dao1;
	}
	
	public static ProductDao prodImpl() {
		ProductDao dao2=new ProductDaoImpl();
		return dao2;
	}
	
	public static AdminDao adminImpl() {
		AdminDao dao = new AdminDaoImpl();
		return dao;
	}
	
	public static AdminBean adminBeanimp() {
		AdminBean bean = new AdminBean();
		return bean;
		
	}
	
	public static ClientDao clientIml() {
		return new ClientDaoImpl();
	}
	
	public static ClientBean clientBean() {
		return new ClientBean();
	}
	
	public static SchedulerDao getSchedulerDaoImpl() {
		return new SchedulerDaoImpl();
		
	}
	
	
	
	public static LandDao getLandDao() {
		LandDao dao = (LandDao) new LandDaoImpl();
		return dao;
	}
	
	
	

}
