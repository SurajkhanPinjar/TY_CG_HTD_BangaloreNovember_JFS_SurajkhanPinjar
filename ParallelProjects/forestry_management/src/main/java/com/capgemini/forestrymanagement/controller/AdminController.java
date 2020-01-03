package com.capgemini.forestrymanagement.controller;

import java.util.Scanner;

import com.capgemini.forestrymanagement.exception.AdminExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.AdminService;


public class AdminController {
	public static void adminController() {
		
		AdminService serv = Factory.getAdminService();
		com.capgemini.forestrymanagement.dto.Admin bean = Factory.getAdmin();
		Scanner sc=new Scanner(System.in);
		
		char ch = 'y';
		while(ch == 'y') {
			int choic = 0;
			char ch1 = 'y';
			while( ch1 == 'y') {
				System.out.println("Enter 1 : Sign Up Admin\nEnter 2 : Login Admin\nEnter 3 : Home");
				String v1 = sc.next();
				
				if (Validation.isNumber1(v1)) {
				  choic = Integer.parseInt(v1);
					ch1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
		
		switch (choic) {
		case 1 :
			
			char d1 = 'y';
			while( d1 == 'y') {
			System.out.println("Enter the Admin id: ");
			String v1 = sc.next();
			if (isNumber(v1)) {
				int v22 = Integer.parseInt(v1);
				bean.setAdminId(v22);
				d1 ='n';
			}else {
				System.err.println("Enter only integers:");
			}
			}
			
			char a1 = 'y';
			while(a1 == 'y') {
			System.out.println("enter the Admin name");
			String cname = sc.next();
			if (Validation.isStringOnlyAlphabet(cname)) {
				a1 = 'n';
				bean.setAdminName(cname);				
			}else {
				System.err.println("Enter only Alphabets!!!!");
			}
			}
			
			char a5 = 'y';
			while(a5 == 'y') {
				System.out.println("enter the Email: ");
				String cadd3 = sc.next();
				if (Validation.isValid(cadd3)) {
					a5 = 'n';
					bean.setAdminMail(cadd3);				
				}else {
					System.err.println("Email currect Format!!!!");
				}
				}
			
			char m1 = 'y';
			while(m1 == 'y') {
				System.out.println("Enter the Password:");
				String cadd3 = sc.next();
				int strength = Validation.calculatePasswordStrength(cadd3);
				System.out.println("Your Password Strength is :" +strength);
				if (strength == 10) {
					m1 = 'n';
					bean.setAdminPassword(cadd3);				
				}else {
					System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 10 digits  "
							+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
				}
			}
			
			
			
			
			try {
				if (serv.addAdmin(bean)) {
					System.out.println("Admin Added Successfully...");
				}
			} catch (AdminExceptions e) {
				System.err.println(e.getMessage());
			} 
			break;
			
		case 2: 
			
			char d2 = 'y';
			while( d2 == 'y') {
			System.out.println("Enter the Admin id: ");
			String v1 = sc.next();
			if (isNumber(v1)) {
				int v22 = Integer.parseInt(v1);
				bean.setAdminId(v22);
				d2 ='n';
			}else {
				System.err.println("Enter only integers:");
			}
			}
			
			System.out.println("Enter The Password");
			bean.setAdminPassword(sc.next());
				
			if(serv.loginAdmin(bean.getAdminId(), bean.getAdminPassword())){
				System.out.println("Successfully Logged in ");
				
				Admin.mainAdmin();
			}
			
			break;
		
		case 3: 
			ch = 'n';
			HomeForestry.mainHomeForestry();
			break;
		default:
			System.err.println("Invalic Choice :( ");
			break;
		}
		
		}
	}
	
	public static boolean isNumber(String s) {
		try {
			long t = Long.parseLong(s);
			return true;
		}catch (Exception e) {
			return false;
		}
		
		}


}
