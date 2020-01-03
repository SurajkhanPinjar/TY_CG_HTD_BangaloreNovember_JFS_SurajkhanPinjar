package com.capgemini.forestry.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.bean.SchedulerBean;
import com.capgemini.forestry.exception.SchedulerExceptions;
import com.capgemini.forestry.factory.Factory1;
import com.capgemini.forestry.services.SchedulerServ;

public class SchedulerController {
	private static Scanner sc = new Scanner(System.in);
	
	public static void schedulerController() {
		SchedulerServ schedService = Factory1.getScheduServ();
		SchedulerBean schedBean = Factory1.getSchedBean();
		
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
						schedBean.setSchedulerPass(cadd3);				
					}else {
						System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
								+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}
				
				try {
					if(schedService.addScheduler(schedBean)) {
						System.out.println("Added Successfully");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
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
				schedBean.setSchedulerPass(sc.next());
				
				try {
					if(schedService.deleteScheduler(schedBean.getSchedulerId(), schedBean.getSchedulerPass())) {
						System.out.println("Deleted  Successfully");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				} 
				break ;
				
			case 3 :
				try {
				List<SchedulerBean> l = schedService.getAllScheduler();
				for (SchedulerBean schedulerBean : l) {
					if (l != null) {
						System.out.println("Scheduler Id :" + schedulerBean.getSchedulerId());
						System.out.println("Schedular Name :" + schedulerBean.getSchedulerName());
						System.out.println("------------------------");
					}	
					}
				} catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());

				}	
				break;
			
			case 4:
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
		SchedulerServ schedService = Factory1.getScheduServ();
		SchedulerBean schedBean = Factory1.getSchedBean();
		
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
		schedBean.setSchedulerPass(sc.next());
		
		try {
			if(schedService.loginScheduler(schedBean.getSchedulerId(), schedBean.getSchedulerPass())) {
				System.out.println("Login  Successfully");
				Schedular.mainSchedular();
			}
		} catch (SchedulerExceptions e) {
			System.err.println(e.getMessage());
		} 
	
		}
		}
}
