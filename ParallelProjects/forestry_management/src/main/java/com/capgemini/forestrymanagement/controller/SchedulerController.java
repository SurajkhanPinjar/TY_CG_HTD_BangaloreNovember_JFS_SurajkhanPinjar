package com.capgemini.forestrymanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Scheduler;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.SchedulerServ;


public class SchedulerController {
	private static Scanner sc = new Scanner(System.in);
	private static SchedulerServ schedService = Factory.getSchedulerService();
	private static Scheduler schedBean = Factory.getScheduler();
	
	public static void schedulerController() {
		
		int choice = 0 ;
		
		char c = 'a';
		while(c == 'a') {
			char ch1 = 'y';
			while( ch1 == 'y') {
				System.out.println("Enter 1 : Create Scheduler \nEnter 2 : Delete Scheduler  \nEnter 3 : Get All Schedulers \nEnter 4 : Back\nEnter 5 : Home");
				String v1 = sc.next();
				
				if (Validation.isNumber1(v1)) {
				  choice = Integer.parseInt(v1);
					ch1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
			
			switch (choice)	{
			case 1 :
				char s1 = 'y';
				int d1 = 0;
				while( s1 == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						d1  = Integer.parseInt(v1);
						s1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				schedBean.setSchedulerId(d1);
				
				char s2 = 'y';
				while(s2 == 'y') {
					System.out.println("Enter The Scheduler Name :");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						s2 = 'n';
						schedBean.setSchedulerName(cadd3);
					}else {
						System.err.println("Enter Only Charecters!!!!");
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
						schedBean.setSchedulerPassword(cadd3);				
					}else {
						System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
								+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}
				
				if(schedService.addScheduler(schedBean)) {
					System.out.println("Added Successfully");
				} else {
					System.err.println("Scheduler Cannot be Added :( ");
					
				}
				break;
			
			case 2 :
				char s4 = 'y';
				int d4 = 0;
				while( s4== 'y') {
					System.out.println("Enter The Scheduler Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						d4  = Integer.parseInt(v1);
						s4 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				schedBean.setSchedulerId(s4);
				
				System.out.println("Enter The Password :");
				schedBean.setSchedulerPassword(sc.next());
				
				if(schedService.deleteScheduler(schedBean.getSchedulerId())) {
					System.out.println("Deleted  Successfully");
				} else {
					System.err.println("Invalid Account ");
				}
				break ;
				
			case 3 :
				List<Scheduler> l = schedService.getAllScheduler();
				try {
				for (Scheduler Scheduler : l) {
					if (l != null) {
						System.out.println("Scheduler Id :" + Scheduler.getSchedulerId());
						System.out.println("Schedular Name :" + Scheduler.getSchedulerName());
						System.out.println("------------------------");
					}	
					}
				} catch (Exception e) {
					System.err.println("No Schedulars Present :(");

				}	
				break;
			
			case 4:
				char f1 = 'y';
				int f = 0;
				while( f1 == 'y') {
					System.out.println("----MODIFICATION----");
					System.out.println("Enter 1 : Scheduler Name\nEnter 2 : Scheduler Password\n"
							+ "Enter 3 : Back\nEnter 4 : Home");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						f = Integer.parseInt(v1);
						f1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}		
				
				switch (f) {
				case 1:
					char i1 = 'y';
					int j1 = 0;
					while( i1 == 'y') {
						System.out.println("Enter The Scheduler Id :");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j1  = Integer.parseInt(v1);
							i1 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					schedBean.setSchedulerId(j1);
					
					char j2 = 'y';
					while(j2 == 'y') {
						System.out.println("Enter The Scheduler Name :");
						String cadd3 = sc.next();
						if (Validation.isStringOnlyAlphabet(cadd3)) {
							j2 = 'n';
							schedBean.setSchedulerName(cadd3);
						}else {
							System.err.println("Enter Only Charecters!!!!");
						}
					}
					try {
						if(schedService.modifyScheduler(schedBean.getSchedulerId(), schedBean.getSchedulerName())) {
							System.out.println("Successfully updated");
						}
					} catch (Exception e) {
						System.err.println("Cannot be Modified :");
					}
					break;
					
				case 2 :
					char i3 = 'y';
					int j3 = 0;
					while( i3 == 'y') {
						System.out.println("Enter The Scheduler Id :");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j3  = Integer.parseInt(v1);
							i3 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					schedBean.setSchedulerId(j3);
					
					char j4 = 'y';
					while(j4 == 'y') {
						System.out.println("Enter the Password:");
						String cadd3 = sc.next();
						int strength = Validation.calculatePasswordStrength(cadd3);
						System.out.println("Your Password Strength is :" +strength);
						if (strength == 8) {
							j4 = 'n';
							schedBean.setSchedulerPassword(cadd3);				
						}else {
							System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
									+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
						}
					}
					
				
				}
				
				return;
			case 5: 
				HomeForestry.mainHomeForestry();
				break;
				
			default :
				System.err.println("Invalid Choice :");
				break ;
				
			}
	}
	}
	
	public static void loginScheduler() {
		
		while(true) {
		char s3 = 'y';
		int d2 = 0;
		while( s3 == 'y') {
			System.out.println("----PLEASE LOGIN----");
			System.out.println("Enter The Scheduler Id :");
			String v1 = sc.next();
			if (Validation.isNumber1(v1)) {
				d2  = Integer.parseInt(v1);
				s3 ='n';
			}else {
				System.err.println("Enter only integers:");
			}
		}
		schedBean.setSchedulerId(d2);
		
		
		System.out.println("Enter The Password :");
		schedBean.setSchedulerPassword(sc.next());
		
		if(schedService.loginScheduler(schedBean.getSchedulerId(), schedBean.getSchedulerPassword())) {
			System.out.println("Login  Successfully");
			Schedular.mainSchedular();
		} else {
			System.err.println("Invalid Account ");
		}
	
		}
		}
}
