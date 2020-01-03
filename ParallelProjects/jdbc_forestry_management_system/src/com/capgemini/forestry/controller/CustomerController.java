package com.capgemini.forestry.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.exception.CustomerExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.services.CustomerServices;

public class CustomerController {
	
	static CustomerBean bean;
	
	public static void custControl() {
		
		
		CustomerServices serv = Factory.getCustServ();
		 bean = Factory.getCustBean();
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
			bean.setCustomerId(s2);
			
			char a1 = 'y';
			while(a1 == 'y') {
			System.out.println("Enter the customer name");
			String cname = sc.next();
			if (Validation.isStringOnlyAlphabet(cname)) {
				a1 = 'n';
				bean.setCustomerName(cname);				
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
					bean.setStreetAdd1(cadd1);				
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
					bean.setStreetAdd2(cadd1);				
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
					bean.setTown(cadd2);				
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
			bean.setPostalCode(n2);
			
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
			bean.setTelephone(n1);
			
			char a5 = 'y';
			while(a5 == 'y') {
				System.out.println("enter the Email: ");
				String cadd3 = sc.next();
				if (Validation.isValid(cadd3)) {
					a5 = 'n';
					bean.setEmail(cadd3);				
				}else {
					System.err.println("Email currect Format!!!!");
				}
				}
			
			try {
				if(serv.addCustomer(bean)) {
					System.out.println("Add Successfully");
				}
			} catch (CustomerExceptions e1) {
				System.err.println(e1.getMessage());
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
			bean.setCustomerId(s3);
			
			char m3 = 'y';
			long n3 = 0;
			while( m3 == 'y') {
				System.out.println("Enter the Telephone: ");
				String v1 = sc.next();
				if (Validation.isValidTel(v1)) {
				  n3 = Long.parseLong(v1);
					m3 ='n';
				}else {
					System.err.println("Enter Valid phone no:");
				}
			}	
			bean.setTelephone(n3);
			
			try {
				if(serv.deleteCustomer(bean.getCustomerId(), bean.getTelephone())){
					System.out.println("Successfully deleted");
				}
			} catch (CustomerExceptions e1) {
				System.err.println(e1.getMessage());
			}
			break;
		
		case 3:
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
			bean.setCustomerId(s4);
			
			
			try {
				if(serv.modifyCustomer(bean.getCustomerId())) {
					System.out.println("Successfully updated");
				}
			} catch (CustomerExceptions e1) {
				System.err.println(e1.getMessage());
			}
			break;
		
		case 4:
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
			bean.setCustomerId(s5);
			
			char m4 = 'y';
			long n4 = 0;
			while( m4 == 'y') {
				System.out.println("Enter the Telephone: ");
				String v1 = sc.next();
				if (Validation.isValidTel(v1)) {
				  n4 = Long.parseLong(v1);
					m4 ='n';
				}else {
					System.err.println("Enter Valid phone no:");
				}
			}	
			bean.setTelephone(n4);

			try {
			ArrayList<CustomerBean> b1 = serv.getCustomer(bean.getCustomerId(), bean.getTelephone());
			for (CustomerBean customerBean : b1) {
				if(b1 != null ) {
					System.out.println("Customer ID: " + customerBean.getCustomerId());
					System.out.println("Customer name: "+ customerBean.getCustomerName());
					System.out.println("Street address 1: "+ customerBean.getStreetAdd1());
					System.out.println("Street address 2: "+ customerBean.getStreetAdd2());
					System.out.println("Town :"+ customerBean.getTown());
					System.out.println("Postal Code: "+ customerBean.getPostalCode());
					System.out.println("Telephone: "+ customerBean.getTelephone());
					System.out.println("Email: "+customerBean.getEmail());
					System.out.println("------------------------");
				}
			}
			} catch (CustomerExceptions e) {
				System.err.println(e.getMessage());
			}
			break;
			
		case 5: 
			try {
			ArrayList<CustomerBean> b2 = serv.getAllCust();
			for (CustomerBean customerBean : b2) {
				if(b2 != null ) {
					System.out.println("Customer ID: " + customerBean.getCustomerId());
					System.out.println("Customer name: "+ customerBean.getCustomerName());
					System.out.println("Street address 1: "+ customerBean.getStreetAdd1());
					System.out.println("Street address 2: "+ customerBean.getStreetAdd2());
					System.out.println("Town :"+ customerBean.getTown());
					System.out.println("Postal Code: "+ customerBean.getPostalCode());
					System.out.println("Telephone: "+ customerBean.getTelephone());
					System.out.println("Email: "+customerBean.getEmail());
					System.out.println("------------------------");
				}
			}
			} catch (CustomerExceptions e) {
				System.err.println(e.getMessage());
			}
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
}
