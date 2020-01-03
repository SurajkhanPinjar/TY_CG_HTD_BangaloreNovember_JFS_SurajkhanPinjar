package com.capgemini.forestry.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.exception.ContractsExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.services.ContractorServices;

public class ContractorController {

	public static void contractorContr() {

		ContractorServices serv = Factory.getContrServ();
		ContractorBean bean = Factory.getContrBean();
		Scanner sc = new Scanner(System.in);

		char a = 'y';
		while (a == 'y') {

				char ch1 = 'y';
				int c1 = 0;
				while( ch1 == 'y') {
					System.out.println("----CONTRACTS----");
					System.out.println("Enter 1 : Add Contracts\nEnter 2 : Delete Contracts\nEnter 3 : Get Contracts\n"
							+ "Enter 4 : Get All Contracts\nEnter 5 : Modify Contracts\nEnter 6 : Back\nEnter 7 : Home");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c1  = Integer.parseInt(v1);
						ch1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}		
				switch (c1) {
				case 1:
						char ch2 = 'y';
						int c2 = 0;
						while( ch2 == 'y') {
							System.out.println("Enter The Contract no:");
							String v1 = sc.next();
							if (Validation.isNumber1(v1)) {
								c2  = Integer.parseInt(v1);
								ch2 ='n';
							}else {
								System.err.println("Enter only integers:");
							}
						}
						bean.setContractNo(c2);
						
						char ch3 = 'y';
						int c3 = 0;
						while( ch3 == 'y') {
							System.out.println("Enter the Customer id:");
							String v1 = sc.next();
							if (Validation.isNumber1(v1)) {
								c3  = Integer.parseInt(v1);
								ch3 ='n';
							}else {
								System.err.println("Enter only integers:");
							}
						}	
					bean.setCustomerId(c3);
					
					char ch4 = 'y';
					int c4 = 0;
					while( ch4 == 'y') {
						System.out.println("Enter Product Id:");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							c4  = Integer.parseInt(v1);
							ch4 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}	
					bean.setProdId(c4);
					
					char ch5 = 'y';
					int c5 = 0;
					while( ch5 == 'y') {
						System.out.println("Enter Haulier id :");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							c5  = Integer.parseInt(v1);
							ch5 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}	
					bean.setHaulierId(c5);
					
					char b9 = 'y';
					while(b9 == 'y') {
						System.out.println("Enter Delivery date (DD/MM/YYYY) : ");
						String cadd3 = sc.next();
						if (!Validation.isValidDate(cadd3)) {
							b9 = 'n';
							bean.setDeliveryDay(cadd3);				
						}else {
							System.err.println("Enter currect Date Format   DD/MM/YYYY!!!!\n");
						}
					}
					
					char b4 = 'y';
					while(b4 == 'y') {
						System.out.println("enter the Delivery Day : ");
						String cadd3 = sc.next();
						if (Validation.isValidDay(cadd3)) {
							b4 = 'n';
							bean.setDeliveryDay(cadd3);				
						}else {
							System.err.println("Enter currect day Format!!!!");
						}
					}
					
					char ch6 = 'y';
					int c6 = 0;
					while( ch6 == 'y') {
						System.out.println("Enter the Quantity: ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							c6  = Integer.parseInt(v1);
							ch6 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}	
					bean.setQty(c6);
					
					try {
						if(serv.addContractor(bean)) {
							System.out.println("Add Successfully");
						}
					} catch (ContractsExceptions e1) {
						System.err.println(e1.getMessage());
					} 

					break;
				
				case 2:
					char ch7 = 'y';
					int c7 = 0;
					while( ch7 == 'y') {
						System.out.println("Enter Contractor id to delete: ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							c7  = Integer.parseInt(v1);
							ch7 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}	
					bean.setContractNo(c7);

					try {
						if(serv.deleteContractor(bean.getContractNo())){
							System.out.println("Successfully deleted");
						}
					} catch (ContractsExceptions e1) {
						System.err.println(e1.getMessage());
					}
					break;

				case 3:
					
					char ch8 = 'y';
					int c8 = 0;
					while( ch8 == 'y') {
						System.err.println("Enter Contractor no:");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							c8  = Integer.parseInt(v1);
							ch8 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}	
					bean.setContractNo(c8);

					try {
					ArrayList<ContractorBean> b1 = serv.getContractor(bean.getContractNo());
					for (ContractorBean contractorBean : b1) {
						if (b1 != null && !b1.isEmpty()) {
							System.out.println("Contract no :"+ contractorBean.getContractNo());
							System.out.println("Customer Id : "+ contractorBean.getCustomerId());
							System.out.println("Product id  :"+ contractorBean.getProdId());
							System.out.println("Haulier Id : "+ contractorBean.getHaulierId());
							System.out.println("Delivery Date :"+ contractorBean.getDeliveryDate());
							System.out.println("Delivery Day : "+ contractorBean.getDeliveryDay());
							System.out.println("Quantity :" + contractorBean.getQty());
						}
					}
					} catch (ContractsExceptions e) {
						System.err.println(e.getMessage());
					}
					break;

				case 4:
					try {
					ArrayList<ContractorBean> b2 = serv.getAllContractor();
					for (ContractorBean contractorBean : b2) {
						if (b2 != null) {
							System.out.println("Contract no :"+ contractorBean.getContractNo());
							System.out.println("Customer Id : "+ contractorBean.getCustomerId());
							System.out.println("Product id  :"+ contractorBean.getProdId());
							System.out.println("Haulier Id : "+ contractorBean.getHaulierId());
							System.out.println("Delivery Date :"+ contractorBean.getDeliveryDate());
							System.out.println("Delivery Day : "+ contractorBean.getDeliveryDay());
							System.out.println("Quantity :" + contractorBean.getQty());
							System.out.println("-----------------------");
						}
					}
					} catch (ContractsExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
					
				case 5:
					char d = 'y';
					int s4 = 0;
					while( d == 'y') {
						System.out.println("Enter Contract no : ");
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
						  s4 = Integer.parseInt(v1);
							d ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}
					bean.setContractNo(s4);
					
					try {
						if(serv.modifyContractor(bean.getContractNo() )) {
							System.out.println("Successfully Modified");
						}
					} catch (ContractsExceptions e) {
						System.err.println(e.getMessage());
						}
					break;
					
				case 6:
					a = 'n';
					break;

				case 7:
					HomeForestry.mainHomeForestry();


				default:
					System.err.println("InValid choice :( ");
					break;
				}
			}	
		}

	}
