package com.capgemini.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.UserDao;
import com.capgemini.healthcare.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User loginUser(User user) {
		return userDao.loginUser(user);
	}

}
