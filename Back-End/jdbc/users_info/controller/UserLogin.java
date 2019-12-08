package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UserLogin {
	public static void main(String[] args) {
		UserServices services = UserFactory.instanceOfUserServices();
		UserBean user= new UserBean();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Username:");
		user.setUsername(sc.nextLine());
		System.out.println("Enter The Password");
		user.setPassword(sc.nextLine());
		UserBean user1=services.userLogin(user.getUsername(), user.getPassword());
		if(user1!=null) {
			System.out.println("Userid :"+user1.getUserid());
			System.out.println("Username :"+user1.getUsername());
			System.out.println("Email: "+user1.getEmail());
		}else {
			System.err.println("Something Went Wrong...");
		}
	}

}
