package com.capgemini.forestmanagement.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.LandBean;
import com.capgemini.forestmanagement.bean.SchedulerBean;
import com.capgemini.forestmanagement.dao.ContractMain;
import com.capgemini.forestmanagement.dao.SchedulerDao;
import com.capgemini.forestmanagement.exception.SchedulerExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;

public class SchedulerMain {
	public static SchedulerDao dao = Factory.getSchedulerDaoImpl();
	static Scanner sc = new Scanner(System.in);

	public static void mainScheduler() {

		while(true) {

			int c = 0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("----SCHEDULER----");
				System.out.println("Enter 1 : Create Scheduler \nEnter 2 : Delete Scheduler \n"
						+ "Enter 3 : Show All Scheduler \nEnter 4 : Search Scheduler \nEnter 5 : Update Scheduler \nEnter 6 : Back \nEnter 7 : Home\n ");
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
				SchedulerBean bean = new SchedulerBean();

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
				bean.setSchedId(d1);

				char s2 = 'y';
				while(s2 == 'y') {
					System.out.println("Enter The Scheduler Name :");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						s2 = 'n';
						bean.setSchedName(cadd3);
					}else {
						System.err.println("Enter Only Charecters!!!!");
					}
				}

				char a5 = 'y';
				while(a5 == 'y') {
					System.out.println("enter the Email: ");
					String cadd3 = sc.next();
					if (Validation.isValid(cadd3)) {
						a5 = 'n';
						bean.setSchedMail(cadd3);				
					}else {
						System.err.println("Enter valid Email Format!!!!");
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
						bean.setSchedPassword(cadd3);				
					}else {
						System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
								+ "1Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}

				try {
					if(dao.addScheduler(bean)) {
						System.out.println("Added Successfully :)");

					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
				} 
				break;

			case 2:
				SchedulerBean sbean = new SchedulerBean();

				char r1 = 'y';
				int t1 = 0;
				while( r1 == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						t1  = Integer.parseInt(v1);
						r1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				sbean.setSchedId(t1);

				System.out.println("Enter The Scheduler Password :");
				sbean.setSchedPassword(sc.next());
				try {
					if(dao.deleteScheduler(sbean.getSchedId(), sbean.getSchedPassword())) {
						System.out.println("Deleted Successfully :)");
					}
				} catch (SchedulerExceptions e1) {
					System.err.println(e1.getMessage());
					} 
				break ;

			case 3:

				List<SchedulerBean> list2 = new ArrayList<SchedulerBean>();
				try {
					list2 = dao.getAllScheduler(); 
					for (SchedulerBean schedulerBean : list2) {

						if (list2 != null ) {
							System.out.println("Scheduler Id 		:"+schedulerBean.getSchedId());
							System.out.println("Scheduler Name		:"+schedulerBean.getSchedName());
							System.out.println("Scheduler Email Id	:"+schedulerBean.getSchedMail());
							System.out.println("------------------------------------");
						} 
					} 
				}catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());
				}

				break ;

			case 4 :
				SchedulerBean sbean3 = new SchedulerBean();
				char r2 = 'y';
				int t2 = 0;
				while( r2 == 'y') {
					System.out.println("Enter The Scheduler Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						t2  = Integer.parseInt(v1);
						r2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				sbean3.setSchedId(t2);

				List<SchedulerBean> list1 = new ArrayList<SchedulerBean>();
				try {
				list1 = dao.searchScheduler(sbean3.getSchedId()); 
					for (SchedulerBean schedulerBean : list1) {

						if (list1 != null ) {
							System.out.println("Scheduler Id 		:"+schedulerBean.getSchedId());
							System.out.println("Scheduler Name		:"+schedulerBean.getSchedName());
							System.out.println("Scheduler Email Id	:"+schedulerBean.getSchedMail());
							System.out.println("------------------------------------");
						} 
					} 
				}catch (SchedulerExceptions e) {
					System.err.println(e.getMessage());
				}

				break;
			case 5:
				break;

			case 6:
				return;
			case 7: 
				MainHome.mainHome();
				break;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}
	}

	public static void loginScheduler() {
		SchedulerBean b1 =  new SchedulerBean();
		System.out.println("----LOGIN PAGE----");

		char r1 = 'y';
		int t1 = 0;
		while( r1 == 'y') {
			System.out.println("Enter The Scheduler Id :");
			String v1 = sc.next();
			if (Validation.isNumber1(v1)) {
				t1  = Integer.parseInt(v1);
				r1 ='n';
			}else {
				System.err.println("Enter only integers:");
			}
		}

		System.out.println("Enter The Password :");
		b1.setSchedPassword(sc.next());
		try {
		if(dao.loginScheduler(t1, b1.getSchedPassword())) {
			System.out.println(" Successfully logged in");

			char s1 = 'a';
			while(s1=='a') {

				int c5=0;
				char chh2 = 'y';

				while( chh2 == 'y') {
					System.out.println("Enter 1 : Contracts \nEnter 2 : Customer \nEnter 3 : Products \nEnter 4 : Land  \nEnter 5 : Back \nEnter 6 : Home ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c5 = Integer.parseInt(v1);
						chh2 ='n';
					}else {
						System.out.println("Enter only integers:");
					}
				}

				switch (c5) {
				case 1 :
					ContractMain.contractMain();
					break;

					//Customer
				case 2 :
					char d2 = 'a';
					while(d2 =='a') {

						int x = 0;
						char shh1 = 'y';
						while( shh1 == 'y') {
							System.out.println("Enter 1 : Search Customer \nEnter 2 : Get All Customers \nEnter 3 : Back \nEnter 4 : Home \n");
							String v1 = sc.next();
							if (Validation.isNumber1(v1)) {
								x = Integer.parseInt(v1);
								shh1 ='n';
							}else {
								System.out.println("Enter only integers:");
							}
						}
						switch (x) {
						case 1:
							CustomerMain.searchCustomer();
							break;

						case 2 :
							CustomerMain.showAllCustomer();
							break;

						case 3:
							//Back
							d2 = 'b';
						case 4:
							MainHome.mainHome();
							break;

						default :
							System.out.println("Invalid Choice :(");
							break;
						}

					}


					break;

					//Products
				case 3:
					System.out.println("----PRODUCT DETAILS---");
					ProductMain.getProducts();
					break;

				case 4:
					char d3 = 'a';
					while(d3 =='a') {

						int x1 = 0;
						char shh6 = 'y';
						while( shh6 == 'y') {
							System.out.println("----LAND PAGE----");
							System.out.println("Enter 1 : Search Land \nEnter 2 : Get All Land Details\nEnter 3 : Back \nEnter 4 : Home \n");
							String v1 = sc.next();
							if (Validation.isNumber1(v1)) {
								x1 = Integer.parseInt(v1);
								shh6 ='n';
							}else {
								System.out.println("Enter only integers:");
							}
						}
						switch (x1) {
						case 1:
							LandMain.searchLand();
							break;

						case 2 :
							LandMain.getAllLand();
							break;

						case 3:
							//Back
							d3 = 'b';
						case 4:
							MainHome.mainHome();
							break;

						default :
							System.err.println("Invalid Choice :(");
							break;
						}

					}
					return;

				case 5:
					s1 = 'b';
					break;

				case 6:
					MainHome.mainHome();
					break;
				default:
					System.err.println("Invalid Choice :(");
					break;
				}

			}



		}
	
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}
