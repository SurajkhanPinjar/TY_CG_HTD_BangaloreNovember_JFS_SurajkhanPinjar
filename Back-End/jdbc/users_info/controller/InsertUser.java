package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class InsertUser {
	public static void main(String[] args) {
		UserServices services = UserFactory.instanceOfUserServices();
		UserBean user= new UserBean();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the Userid:");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter the User Name:");
		user.setUsername(sc.nextLine());
		System.out.println("Enter Email id:");
		user.setEmail(sc.nextLine());
		System.out.println("Enter The Password");
		user.setPassword(sc.nextLine());
		
		if (services.insertUser(user)) {
			System.out.println("User Inserted...");
		} else {
			System.out.println("Something Went Wrong...");
		}
	}
}
