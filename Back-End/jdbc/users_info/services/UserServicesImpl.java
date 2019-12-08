package com.capgemini.jdbc.services;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.UserDao;
import com.capgemini.jdbc.factory.UserFactory;

public class UserServicesImpl implements UserServices{

	UserDao dao=UserFactory.instanceOfUserDaoImpl();
	
	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	@Override
	public UserBean userLogin(String username, String password) {
		return dao.userLogin(username, password);
	}

	@Override
	public boolean updateUser(String email, int userid, String password ) {
		return dao.updateUser(email, userid, password);
	}

	@Override
	public boolean deleteUser(int userid, String password) {
		return dao.deleteUser(userid, password);
				}

	@Override
	public boolean insertUser(UserBean user) {
		
		return dao.insertUser(user);
	}
	

}
