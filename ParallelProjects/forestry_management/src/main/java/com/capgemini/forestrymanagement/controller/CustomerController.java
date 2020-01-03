package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.exception.CustomerExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.CustomerService;


public class CustomerController {
	private static	CustomerService serv = Factory.getCustomerServImpl();
	private static Customer cBean = Factory.getCustomer();

	public static void custControl() {

		Scanner sc = new Scanner(System.in);
		char a = 'y';
		while(a == 'y') {
			char ch1 = 'y';
			int c = 0;
			while( ch1 == 'y') {
				System.out.println("----Customer----");
				System.out.println("Enter 1 : Add Customer\nEnter 2 : Delete Customer\nEnter 3 : Modify Customer\nEnter 4 : Get Customer\nEnter 5 : Get All Customers\nEnter 6 : Back\nEnter 7 : Home");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					c = Integer.parseInt(v1);
					ch1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}		
			switch (c) {
			case 1:
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
				cBean.setCustomerId(s2);

				char a1 = 'y';
				while(a1 == 'y') {
					System.out.println("Enter the customer name");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						a1 = 'n';
						cBean.setCustomerName(cname);				
					}else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char a2 = 'y';
				while(a2 == 'y') {
					System.out.println("Enter the Street Address 1");
					String cadd1 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd1)) {
						a2 = 'n';
						cBean.setStreetAdd1(cadd1);				
					}else {
						System.err.println("Enter only Alphabets!!!!!");
					}
				}

				char a3 = 'y';
				while(a3 == 'y') {
					System.out.println("Enter the Street Address 2");
					String cadd1 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd1)) {
						a3 = 'n';
						cBean.setStreetAdd2(cadd1);				
					}else {
						System.err.println("Enter only Alphabets!!!!!");
					}
				}

				char a4 = 'y';
				while(a4 == 'y') {
					System.out.println("enter the Town..");
					String cadd2 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd2)) {
						a4 = 'n';
						cBean.setTown(cadd2);				
					}else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char m2 = 'y';
				int n2 = 0;
				while( m2 == 'y') {
					System.out.println("Enter The Postal Code :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1) && v1.length()==6) {
						n2 = Integer.parseInt(v1);
						m2 ='n';
					}else {
						System.err.println("Enter only 6 digit integers Allowed:");
					}
				}	
				cBean.setPostalCode(n2);

				char m1 = 'y';
				long n1 = 0;
				while( m1 == 'y') {
					System.out.println("Enter the Telephone: ");
					String v1 = sc.next();
					if (Validation.isValidTel(v1)) {
						n1 = Long.parseLong(v1);
						m1 ='n';
					}else {
						System.err.println("Enter Valid phone no:");
					}
				}	
				cBean.setTelephone(n1);

				char a5 = 'y';
				while(a5 == 'y') {
					System.out.println("enter the Email: ");
					String cadd3 = sc.next();
					if (Validation.isValid(cadd3)) {
						a5 = 'n';
						cBean.setEmail(cadd3);				
					}else {
						System.err.println("Email currect Format!!!!");
					}
				}

				try {
					if(serv.addCustomer(cBean)) {
						System.out.println("Add Successfully");
					}
				} catch (CustomerExceptions e2) {
					System.err.println(e2.getMessage());
				}  
				break;

			case 2: 
				char ch3 = 'y';
				int s3 = 0;
				while( ch3 == 'y') {
					System.out.println("Enter Customer id: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						s3 = Integer.parseInt(v1);
						ch1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				cBean.setCustomerId(s3);

				try {
					if(serv.deleteCustomer(cBean.getCustomerId())){
						System.out.println("Successfully deleted");
					}
				} catch (CustomerExceptions e2) {
					System.err.println(e2.getMessage());
				} 
				break;

			case 3:
				char f1 = 'y';
				int f = 0;
				while( f1 == 'y') {
					System.out.println("----MODIFICATION----");
					System.out.println("Enter 1 : Customer Name\nEnter 2 : Customer Street Address 1\nEnter 3 : Customer Street Address 2\n"
							+ "Enter 4 : Customer Town\nEnter 5 : Customer Postal Code\nEnter 6 : Customer Telephone \n"
							+ "Enter 7 : Customer Email ID");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						f = Integer.parseInt(v1);
						f1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}		
				
				switch (f) {
				case 1 :
					char ch4 = 'y';
					int s4 = 0;
					while( ch4 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							s4 = Integer.parseInt(v1);
							ch4 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(s4);

					char e1 = 'y';
					while(e1 == 'y') {
						System.out.println("Enter the customer name");
						String cname = sc.next();
						if (Validation.isStringOnlyAlphabet(cname)) {
							e1 = 'n';
							cBean.setCustomerName(cname);				
						}else {
							System.err.println("Enter only Alphabets!!!!");
						}
					}
					
					try {
						if(serv.modifyCustomer(cBean.getCustomerId(), cBean.getCustomerName())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
				
				case 2 :
					char i1 = 'y';
					int j1 = 0;
					while( i1 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j1 = Integer.parseInt(v1);
							i1 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(j1);

					char j2 = 'y';
					while(j2 == 'y') {
						System.out.println("Enter the Street Address 1");
						String cadd1 = sc.next();
						if (Validation.isStringOnlyAlphabet(cadd1)) {
							j2 = 'n';
							cBean.setStreetAdd1(cadd1);				
						}else {
							System.err.println("Enter only Alphabets!!!!!");
						}
					}
					
					try {
						if(serv.modifyCustomerAdd1(cBean.getCustomerId(), cBean.getStreetAdd1())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
				case 3:
					char k3 = 'y';
					int j3 = 0;
					while( k3 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j3 = Integer.parseInt(v1);
							k3 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(j3);

					char j4 = 'y';
					while(j4 == 'y') {
						System.out.println("Enter the Street Address 2");
						String cadd1 = sc.next();
						if (Validation.isStringOnlyAlphabet(cadd1)) {
							j4 = 'n';
							cBean.setStreetAdd2(cadd1);				
						}else {
							System.err.println("Enter only Alphabets!!!!!");
						}
					}
					
					try {
						if(serv.modifyCustomerAdd2(cBean.getCustomerId(), cBean.getStreetAdd2())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
				case 4:
					char i5 = 'y';
					int j5 = 0;
					while( i5 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j5 = Integer.parseInt(v1);
							i5 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(j5);

					char j6 = 'y';
					while(j6 == 'y') {
						System.out.println("Enter the Town");
						String cadd1 = sc.next();
						if (Validation.isStringOnlyAlphabet(cadd1)) {
							j6 = 'n';
							cBean.setStreetAdd2(cadd1);				
						}else {
							System.err.println("Enter only Alphabets!!!!!");
						}
					}
					
					try {
						if(serv.modifyCustomerTown(cBean.getCustomerId(), cBean.getTown())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
				case 5:
					char i7 = 'y';
					int j7 = 0;
					while( i7 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j7 = Integer.parseInt(v1);
							i7 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(j7);
					
					char i8 = 'y';
					int j8 = 0;
					while( i8 == 'y') {
						System.out.println("Enter The Postal Code :");
						String v1 = sc.next();
						if (Validation.isNumber1(v1) && v1.length()==6) {
							j8 = Integer.parseInt(v1);
							i8 ='n';
						}else {
							System.err.println("Enter only 6 digit integers Allowed:");
						}
					}	
					cBean.setPostalCode(j8);
					try {
						if(serv.modifyCustomerPost(cBean.getCustomerId(), cBean.getPostalCode())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
				case 6:
					char i9 = 'y';
					int j9 = 0;
					while( i9 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j9 = Integer.parseInt(v1);
							i9 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(j9);
					
					char i10 = 'y';
					while(i10 == 'y') {
						System.out.println("enter the Email: ");
						String cadd3 = sc.next();
						if (Validation.isValid(cadd3)) {
							i10 = 'n';
							cBean.setEmail(cadd3);				
						}else {
							System.err.println("Email currect Format!!!!");
						}
					}
					
					try {
						if(serv.modifyCustomerEmail(cBean.getCustomerId(), cBean.getEmail())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
				case 7:
					char i11 = 'y';
					int j11 = 0;
					while( i11 == 'y') {
						System.out.println("Enter Customer id : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							j11 = Integer.parseInt(v1);
							i11 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					cBean.setCustomerId(j11);
					
					char m11 = 'y';
					long n11 = 0;
					while( m11 == 'y') {
						System.out.println("Enter the Telephone: ");
						String v1 = sc.next();
						if (Validation.isValidTel(v1)) {
							n11 = Long.parseLong(v1);
							m11 ='n';
						}else {
							System.err.println("Enter Valid phone no:");
						}
					}	
					cBean.setTelephone(n11);
					try {
						if(serv.modifyCustomerTel(cBean.getCustomerId(), cBean.getTelephone())) {
							System.out.println("Successfully updated");
						}
					} catch (CustomerExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
					
					default :
						System.err.println("Invalid Choice");
						break;
				}

				break;

			case 4:
				CustomerController.searchCustomer();
				break;

			case 5: 
				CustomerController.getAllCustomer();
				break;

			case 6:
				a = 'n';
				break;

			case 7 :
				HomeForestry.mainHomeForestry();
			default : 
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}

	public static void searchCustomer() {
		Scanner sc = new Scanner(System.in);

		char ch5 = 'y';
		int s5 = 0;
		while( ch5 == 'y') {
			System.out.println("Enter Customer id : ");
			String v1 = sc.next();
			if (Validation.isNumber1(v1)) {
				s5 = Integer.parseInt(v1);
				ch5 ='n';
			}else {
				System.err.println("Enter only integers:");
			}
		}
		cBean.setCustomerId(s5);


		try {
		List<Customer> b1 = serv.getCustomer(cBean.getCustomerId());
			for (Customer Customer : b1) {
				if(b1 != null ) {
					System.out.println("Customer ID: " + Customer.getCustomerId());
					System.out.println("Customer name: "+ Customer.getCustomerName());
					System.out.println("Street address 1: "+ Customer.getStreetAdd1());
					System.out.println("Street address 2: "+ Customer.getStreetAdd2());
					System.out.println("Town :"+ Customer.getTown());
					System.out.println("Postal Code: "+ Customer.getPostalCode());
					System.out.println("Telephone: "+ Customer.getTelephone());
					System.out.println("Email: "+Customer.getEmail());
					System.out.println("------------------------");
				}
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
			CustomerController.custControl();
		}
	}

	public static void getAllCustomer() {
		Scanner sc = new Scanner(System.in);
		try {
		ArrayList<Customer> b2 = serv.getAllCust();
			for (Customer Customer : b2) {
				if(b2 != null ) {
					System.out.println("Customer ID: " + Customer.getCustomerId());
					System.out.println("Customer name: "+ Customer.getCustomerName());
					System.out.println("Street address 1: "+ Customer.getStreetAdd1());
					System.out.println("Street address 2: "+ Customer.getStreetAdd2());
					System.out.println("Town :"+ Customer.getTown());
					System.out.println("Postal Code: "+ Customer.getPostalCode());
					System.out.println("Telephone: "+ Customer.getTelephone());
					System.out.println("Email: "+Customer.getEmail());
					System.out.println("------------------------");
				}
			}
		} catch (CustomerExceptions e) {
			System.err.println(e.getMessage());
			CustomerController.custControl();
		}

	}
}
