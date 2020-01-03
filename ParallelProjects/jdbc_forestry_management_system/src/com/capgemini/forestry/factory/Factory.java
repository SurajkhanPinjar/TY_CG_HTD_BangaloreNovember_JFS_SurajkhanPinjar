package com.capgemini.forestry.factory;

import org.w3c.dom.css.CSSUnknownRule;

import com.capgemini.forestry.bean.AdminBean;
import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.dao.AdminDao;
import com.capgemini.forestry.dao.AdminDaoImpl;
import com.capgemini.forestry.dao.ClientDao;
import com.capgemini.forestry.dao.ClientDaoImpl;
import com.capgemini.forestry.dao.ContractorDao;
import com.capgemini.forestry.dao.ContractorDaoImpl;
import com.capgemini.forestry.dao.CustomerDao;
import com.capgemini.forestry.dao.CustomerDaoImpl;
import com.capgemini.forestry.dao.ProductDao;
import com.capgemini.forestry.dao.ProductDaoImpl;
import com.capgemini.forestry.services.AdminService;
import com.capgemini.forestry.services.AdminServiceImpl;
import com.capgemini.forestry.services.ClientServicesImpl;
import com.capgemini.forestry.services.ClientSevices;
import com.capgemini.forestry.services.ContractorServiceImpl;
import com.capgemini.forestry.services.ContractorServices;
import com.capgemini.forestry.services.CustomerServices;
import com.capgemini.forestry.services.CustomerServicesImpl;
import com.capgemini.forestry.services.ProductServices;
import com.capgemini.forestry.services.ProductServicesImpl;

public class Factory {
	private Factory() {
		
	}
	
			/* Products Factory*/
	public static ProductDao getProdDao() {
		ProductDao dao = new ProductDaoImpl();
		return dao;
	}
	
	public static ProductServices getProdServ() {
		ProductServices serv = new ProductServicesImpl();
		return serv;
	}
	
	public static ProductBean getProdBean() {
		ProductBean bean = new ProductBean();
		return bean;
	}
	
	
	/* Contractor Factory*/
	public static ContractorDao getContrDao() {
		ContractorDao dao = new ContractorDaoImpl();
		return dao;
	}
	
	public static ContractorServices getContrServ() {
		ContractorServices serv = new ContractorServiceImpl();
		return serv;
	}
	
	public static ContractorBean getContrBean() {
		ContractorBean bean = new ContractorBean();
		return bean;
	}
	
	
	/* Customer Factory*/
	public static CustomerServices getCustServ() {
		CustomerServices serv = new CustomerServicesImpl();
		return serv;
	}
	
	public static CustomerDao getCustDao() {
		CustomerDao dao = new CustomerDaoImpl();
		return dao;
	}
	
	
	
	public static CustomerBean getCustBean() {
		CustomerBean bean = new CustomerBean();
		return bean;
	}
	
	
	
	
	
	
	
	/* Admin Factory */
	public static AdminBean getAdminBean() {
		return new AdminBean();
	}
	
	public static AdminService getAdminServ() {
		return (AdminService) new AdminServiceImpl();
	}
	
	public static AdminDao getAdminDao() {
		return new AdminDaoImpl();
	}
	
	
	//Clients
	public static ClientSevices getClientServ() {
		return new ClientServicesImpl();
	}
	
	public static ClientDao getClientDao() {
		return new ClientDaoImpl();
	}
	
	public static ClientBean getClientBean( ) {
		return new ClientBean();
	}
	


	
}
