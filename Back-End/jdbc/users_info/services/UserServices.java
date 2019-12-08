
package com.capgemini.jdbc.services;

import java.util.List;

import com.capgemini.jdbc.bean.UserBean;

public interface UserServices {
	//Get All User
	public List<UserBean> getAllUsers();
	
	//User Login
	public UserBean userLogin(String username, String password);
	
	//Update User
	public boolean updateUser(String email, int userid, String password);
	
	//Delete User
	public boolean deleteUser(int userid, String password);
	
	//Insert User by using User Bean
	public boolean insertUser(UserBean user);
}
