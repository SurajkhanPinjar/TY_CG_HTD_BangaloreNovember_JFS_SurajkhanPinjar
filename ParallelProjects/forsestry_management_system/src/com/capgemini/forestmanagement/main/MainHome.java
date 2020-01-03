package com.capgemini.forestmanagement.main;

import java.util.Scanner;

import com.capgemini.forestmanagement.factory.Validation;

public class MainHome {
	public static void mainHome() {
		System.out.println("-----WELCOME------");

		Scanner sc = new Scanner(System.in);
		while(true) {

			int c=0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("Enter 1 : Admin \nEnter 2 : Client \nEnter 3 : Scheduler \n");
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
				AdminMain.mainAdmin();
				break;

			case 2:
				ClientMain.clientMain();
				break;
			case 3:
				SchedulerSection.schedulerSection();
				break;
			case 4:
				MainHome.mainHome();
				break;

			default:
				System.err.println("Invalid Choice :(\n");
				break;

			}
		}

	}

}
