package com.capgemini.forestry.controller;

import java.util.Scanner;

import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.factory.Factory1;
import com.capgemini.forestry.services.ClientSevices;
import com.capgemini.forestry.services.CustomerServices;
import com.capgemini.forestry.services.ProductServices;

public class Admin {
	public static void mainAdmin() {
		
		CustomerServices serv = Factory.getCustServ();
		ProductServices serv1 = Factory.getProdServ();	
		ProductBean b2 = Factory.getProdBean();
		CustomerBean bean = Factory.getCustBean();
		Scanner sc = new Scanner(System.in);
		ClientSevices servcl = Factory1.getClServ();
		ClientBean cbean = Factory1.getClBean();
		char a = 'y';
		while(true) {
		
			char c = 'a';
			while(c == 'a') {
				char ch1 = 'y';
				int choice = 0;
				while( ch1 == 'y') {
					System.out.println("Welcome you Admin");
					System.out.println("Enter 1 : Contractor\nEnter 2 : Products\nEnter 3 : Customers\n"
										+ "Enter 4 : Client\nEnter 5 : Land\nEnter 6 : Scheduler\nEnter 7 : Home ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
					  choice = Integer.parseInt(v1);
						ch1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
			
		switch (choice) {
		
		case 1:
			ContractorController.contractorContr();		
			break;
			
		case 2:
			System.out.println("----PRODUCTS----");
			ProductController.productContr();
			break;
			
		case 3:
			System.out.println("----CUSTOMER----");
			CustomerController.custControl();
			break;
		
		case 4:
			ClientSection.clientSection();
			break;
			
		case 5 :
			LandController.landController();
			break;
		
		case 6 :
			SchedulerController.schedulerController();
			
		case 7:
			HomeForestry.mainHomeForestry();
			break;
			
		default:
				System.err.println("Invalid  Choice :( ");
				break;
			}
			}	
		}
	}
}


