package com.capgemini.jdbc.factory;

import com.capgemini.jdbc.dao.UserDao;
import com.capgemini.jdbc.dao.UserDaoImpl;
import com.capgemini.jdbc.services.UserServices;
import com.capgemini.jdbc.services.UserServicesImpl;

public class UserFactory {
	private UserFactory() {
		
	}
	public static UserDao instanceOfUserDaoImpl(){
		UserDao dao=new UserDaoImpl();
		return dao;
	}
	
	public static UserServices instanceOfUserServices() {
		UserServices services=new UserServicesImpl();
		return services;
		
	}
}
