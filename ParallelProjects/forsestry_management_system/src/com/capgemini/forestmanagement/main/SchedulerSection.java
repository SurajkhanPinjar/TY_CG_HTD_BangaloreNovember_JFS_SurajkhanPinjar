package com.capgemini.forestmanagement.main;

import java.util.Scanner;

import com.capgemini.forestmanagement.factory.Validation;

public class SchedulerSection {

	public static void schedulerSection() {
		Scanner sc= new Scanner(System.in);
		char c1 = 'a';
		while(c1 =='a') {

			int c=0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("Enter 1 : Login Scheduler \nEnter 2 : Back \nEnter 3 : Home \n");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					c = Integer.parseInt(v1);
					chh1 ='n';
				}else {
					System.out.println("Enter only integers:");
				}
			}

			switch (c) {
			case 1:
				SchedulerMain.loginScheduler();
				break;

			case 2	:
				c1 = 'b';
				return;

			case 3: 
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}

}
