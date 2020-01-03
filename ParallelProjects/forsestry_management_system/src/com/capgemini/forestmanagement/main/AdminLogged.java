package com.capgemini.forestmanagement.main;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.dao.ContractMain;
import com.capgemini.forestmanagement.factory.Validation;

public class AdminLogged {

	public static void adminLogged() {
		Scanner sc =new Scanner(System.in);
		int c = 0;
		while(true) {
			char chhh1 = 'y';
			while( chhh1 == 'y') {
				System.out.println("Enter 1 : Contractor \nEnter 2 : Customer \nEnter 3 : Product\nEnter 4 : Client \nEnter 5 : Scheduler \nEnter 6 : Land \nEnter 7 : Back \nEnter 8 : Home");
				String v1 = sc.next();

				if (Validation.isNumber1(v1)) {
					c = Integer.parseInt(v1);
					chhh1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}	

			switch (c) {
			case 1:	
				ContractMain.contractMain();
				break;
			case 2:
				CustomerMain.customerMain();
				break;

			case 3:
				ProductMain.productMain();
				break;

			case 4:	
				ClientSection.clientSection();
				break;

			case 5 :
				SchedulerMain.mainScheduler();
				break;

			case 6:
				LandMain.mainLand();
				break;

			case 7:
				return;

			case 8:
				MainHome.mainHome();


			default:
				System.err.println("Invalid Choice :(\n");
				break;
			}

		}
	}
}
