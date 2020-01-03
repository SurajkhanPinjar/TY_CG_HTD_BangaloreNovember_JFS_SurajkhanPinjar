package com.capgemini.forestmanagement.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.CustomerBean;
import com.capgemini.forestmanagement.dao.CustomerDao;
import com.capgemini.forestmanagement.exception.CustomerExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;

public class CustomerMain {

	public static CustomerDao dao1= Factory.cstDao();
	public static void customerMain() {

		Scanner sc= new Scanner(System.in);
		int choice = 0;

		while(true) {
			char chhh1 = 'y';
			while( chhh1 == 'y') {
				System.out.println("Enter 1 : Add Customer Details \nEnter 2 : Delete Customer details \nEnter 3 : Modify Customer Details \n"
						+ "Enter 4 : Show All Customer Details \nEnter 5 : Search Customer Details\nEnter 6 : Back \nEnter 7 : Home");
				String v1 = sc.next();

				if (Validation.isNumber1(v1)) {
					choice = Integer.parseInt(v1);
					chhh1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}	

			switch (choice ) {
			case 1:	
				CustomerBean cust = new CustomerBean();
				char ch2 = 'y';
				int s2 = 0;
				while( ch2 == 'y') {
					System.out.println("Enter The customer id:");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						s2 = Integer.parseInt(v1);
						ch2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				cust.setCustId(s2);

				char a = 'y';
				while(a == 'y') {
					System.out.println("Enter the customer name");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						a = 'n';
						cust.setCustomerName(cname);				
					}else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				System.out.println("Enter the Street Address 1");
				cust.setStreetAdd1(sc.next());

				System.out.println("Enter the Street Address 2");
				cust.setStreetAdd2(sc.next());


				char b3 = 'y';
				while(b3 == 'y') {
					System.out.println("Enter the Town ");
					String cadd2 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd2)) {
						b3 = 'n';
						cust.setTown(cadd2);				
					}else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char chh1 = 'y';
				while( chh1 == 'y') {
					System.out.println("Enter the Postal Code: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1) && v1.length()==6) {
						int v22 = Integer.parseInt(v1);
						cust.setPostalCode(v22);
						chh1 ='n';
					}else {
						System.err.println("Enter valid postal code \n(6 digits):");
					}
				}

				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("Enter the Email : ");
					String cadd3 = sc.next();
					if (Validation.isValid(cadd3)) {
						b4 = 'n';
						cust.setEmail(cadd3);				
					}else {
						System.err.println("Enter Valid Email id Format!!!!");
					}
				}


				char chh2 = 'y';
				while( chh2 == 'y') {
					System.out.println("Enter the Telephone : ");
					String v1 = sc.next();
					if (Validation.isValidTel(v1)) {
						long v22 = Long.parseLong(v1);
						cust.setTelephone(v22);
						chh2 ='n';
					}else {
						System.err.println("Enter Valid phone no:");
					}
				}		

				try {
					if(dao1.addCustomer(cust)) {
						System.out.println("Add Successfully");
					}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				} 
				break;

			case 2:
				CustomerBean cust2 = new CustomerBean();
				char ch3 = 'y';
				int s3 = 0;
				while( ch3 == 'y') {
					System.out.println("Enter The customer id:");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						s3 = Integer.parseInt(v1);
						ch3 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				cust2.setCustId(s3);

				try {
					if(dao1.deleteCustomer(cust2.getCustId())) {
						System.out.println("Successfully deleted...");
					}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				} 
				break;



			case 3:
				CustomerBean cust4 = new CustomerBean();
				System.out.println("----Modify the Data------");
				int s4 = 0;
				char chh4 = 'y';
				while( chh4 == 'y') {
					System.out.println("Enter the Cust Id: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						s4 = Integer.parseInt(v1);
						chh4 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				cust4.setCustId(s4);

				try {
					if(dao1.modifyCustomer(cust4.getCustId())) {
						System.out.println("Modified Successfully..");

					}
				} catch (CustomerExceptions e) {
					System.err.println(e.getMessage());
				}

				break;

			case 4:
				CustomerMain.showAllCustomer();
				break;	

			case 5: 
				CustomerMain.searchCustomer();
				break;
			case 6:
				return;

			case 7:
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice:");
				break;
			}
		}

	}
	public static void showAllCustomer() {
		CustomerBean cust3 = new CustomerBean();
		System.out.println("The Details:");
		
		try {
			List<CustomerBean > b = dao1.showAllCustomer(cust3);
			if(b != null) {


				for (CustomerBean customerBean : b) {
					System.out.println("Customer's Name	:"+customerBean.getCustomerName());
					System.out.println("Customer's Postal Code :"+customerBean.getPostalCode());
					System.out.println("Customer's Street Address 1:"+customerBean.getStreetAdd1());
					System.out.println("Customer's Street Address 2:"+customerBean.getStreetAdd2());
					System.out.println("Customer's Telephone :"+customerBean.getTelephone());
					System.out.println("Customer's Town :"+customerBean.getTown());
					System.out.println("Customer's Email :"+customerBean.getEmail());
					System.out.println("---------------------------------------------");

				}
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
		}

	}

	public static void searchCustomer() {
		Scanner sc = new Scanner(System.in);
		CustomerBean cust4 = new CustomerBean();


		int s5 = 0;
		char chh5 = 'y';
		while( chh5 == 'y') {
			System.out.println("Enter the Cust Id: ");
			String v1 = sc.next();
			if (Validation.isNumber1(v1)) {
				s5 = Integer.parseInt(v1);
				chh5 ='n';
			}else {
				System.err.println("Enter only integers:");
			}
		}
		cust4.setCustId(s5);


		try {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		list = dao1.searchCustomer(cust4.getCustId());
			for (CustomerBean customerBean : list) {

				if (list != null ) {
					System.out.println("Customer's Name	:"+customerBean.getCustomerName());
					System.out.println("Customer's Postal Code	:"+customerBean.getPostalCode());
					System.out.println("Customer's Street Address 1	:"+customerBean.getStreetAdd1());
					System.out.println("Customer's Street Address 2	:"+customerBean.getStreetAdd2());
					System.out.println("Customer's Telephone:"+customerBean.getTelephone());
					System.out.println("Customer's Town :"+customerBean.getTown());
					System.out.println("Customer's Email :"+customerBean.getEmail());
					System.out.println("---------------------------------------------");

				} 
			} 
		}catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
		}

	}


}

