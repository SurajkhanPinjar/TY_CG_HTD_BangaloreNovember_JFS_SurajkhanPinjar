package com.capgemini.forestry.controller;

import java.util.Scanner;

public class HomeForestry {
	public static void mainHomeForestry() {
		System.out.println("---------WelCome To Home Page------");
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		char d1 = 'y';
		while( d1 == 'y') {
		System.out.println("Enter 1 : Admin\nEnter 2 : Client\nEnter 3 : Schedular");
		String v1 = sc.next();
		if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
			 ch = Integer.parseInt(v1);
			d1 ='n';
		}else {
			System.err.println("Enter only integers:");
		}
		}
		
		
		switch (ch) {
		case 1:
			AdminController.adminController();		
			break;
		case 2:
			ClientController.mainClientController();
			break;
		
		case 3 :
			SchedulerController.loginScheduler();
			break;
		default:
			System.err.println("Invalid Choice:");
			break;
		}
	}

}
