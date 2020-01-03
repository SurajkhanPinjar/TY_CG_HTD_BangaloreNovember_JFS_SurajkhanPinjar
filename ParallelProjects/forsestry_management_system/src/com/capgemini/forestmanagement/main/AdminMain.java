package com.capgemini.forestmanagement.main;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.AdminBean;
import com.capgemini.forestmanagement.dao.AdminDao;
import com.capgemini.forestmanagement.exception.AdminExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;

public class AdminMain {
	public static AdminDao dao = Factory.adminImpl();
	public static void mainAdmin() {

		Scanner sc = new Scanner(System.in);
		char c1 = 'a';
		while(c1=='a') {

			int c=0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("-----ADMIN PAGE-----");
				System.out.println("Enter 1 : Sign Up Admin \nEnter 2 : Admin Login \nEnter 3 : Back ");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					c = Integer.parseInt(v1);
					chh1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
			switch(c) {
			case 1:
				AdminBean bean = new AdminBean();
				char d1 = 'y';
				while( d1 == 'y') {
					System.out.println("Enter the Admin id: ");
					String v1 = sc.next();
					if (Validation.isNumber(v1)) {
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
						bean.setAName(cname);				
					}else {
						System.err.println("Enter only Alphabets!!!!");
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
						bean.setAPass(cadd3);				
					}else {
						System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
								+ " Atleast 1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				char a5 = 'y';
				while(a5 == 'y') {
					System.out.println("Enter the Email: ");
					String cadd3 = sc.next();
					if (Validation.isValid(cadd3)) {
						a5 = 'n';
						bean.setEmail(cadd3);				
					}else {
						System.err.println("Enter Valid Email id Format!!!!");
					}
				}


				try {
					if(dao.addAdmin(bean)) {
						System.out.println("Update successful");
					}
				} catch (AdminExceptions e) {
						System.err.println(e.getMessage());
				}  
				break;
			case 2:

				AdminBean b1 = new AdminBean();
				int adminid = 0;
				char d2 = 'y';
				while( d2 == 'y') {
					System.out.println("Enter the Admin id: ");
					String v1 = sc.next();
					if (Validation.isNumber(v1)) {
						adminid = Integer.parseInt(v1);
						d2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}

				System.out.println("Enter The Admin Password:");
				b1.setAPass(sc.next());
				
				try {
					if(dao.loginAdmin(adminid, b1.getAPass())) {
						System.out.println("Login Successful:)\n");
						System.out.println("---WELCOME YOU ADMIN----");
						AdminLogged.adminLogged();
					}
				} catch (AdminExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				MainHome.mainHome();
				break;
			default:
				System.err.println("Invalid Choice:");
			}
		}	
	}
}
