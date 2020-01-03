package com.capgemini.forestry.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.exception.CustomerExceptions;
import com.capgemini.forestry.exception.LandExceptions;
import com.capgemini.forestry.exception.SchedulerExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.factory.Factory1;
import com.capgemini.forestry.services.ContractorServices;
import com.capgemini.forestry.services.CustomerServices;
import com.capgemini.forestry.services.LandServices;
import com.capgemini.forestry.services.ProductServices;

public class Schedular {
	public static void mainSchedular() {

		ContractorServices contrService = Factory.getContrServ();
		ContractorBean contrBean = Factory.getContrBean();
		ProductServices prodService = Factory.getProdServ();
		ProductBean prodBean = Factory.getProdBean();
		CustomerServices custService = Factory.getCustServ();
		CustomerBean custBean = Factory.getCustBean();
		LandServices landServ = Factory1.getLandServImpl();
		LandBean lBean = Factory1.getLandBean();


		Scanner sc = new Scanner(System.in);
		char a1 = 'y';
		while(a1 =='y') {		
			int s1 = 0;
			char ch1 = 'y';
			while( ch1 == 'y') {
				System.out.println("-------WELCOME SCHEDULER-------");
				System.out.println("Enter 1 : Contracts\nEnter 2 : Products\nEnter 3 : Customers\nEnter 4 : Land\nEnter 5 : Back\nEnter 6 : Home");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					s1 = Integer.parseInt(v1);
					ch1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}	

			switch (s1) {
			case 1:
				ContractorController.contractorContr();
				break;

			case 2 :
				char c2 = 'y';
				while(c2 =='y') {
					int s3 = 0;
					char ch3 = 'y';
					while( ch3 == 'y') {
						System.out.println("------PRODUCTS------");
						System.out.println("Enter 1 : Get All Products\nEnter 2 : Search Products\nEnter 3 : Back\nEnter 4 : Home" );
						String v1 = sc.next();
						if (Validation.isNumber1(v1)) {
							s3 = Integer.parseInt(v1);
							ch3 ='n';
						}else {
							System.err.println("Enter only integers:");
						}
					}	
					switch (s3) {
					case 1:
						ArrayList<ProductBean> b2= prodService.getAllProduct();
						try {
							for (ProductBean productBean : b2) {


								if (b2 != null) {
									System.out.println("Product Name :"+ productBean.getProductName());
									System.out.println("Product Id :" + productBean.getProductId());
									System.out.println("-------------------------");
								} 
							}
						} catch (SchedulerExceptions e) {
							System.err.println(e.getMessage());
						}
						break;

					case 2 :
						char d3 = 'y';
						while( d3 == 'y') {
							System.out.println("Enter the Prod id: ");
							String v1 = sc.next();
							if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
								int v22 = Integer.parseInt(v1);
								prodBean.setProductId(v22);
								d3 ='n';
							}else {
								System.err.println("Enter only integers:");
							}
						}

						try {
						ArrayList<ProductBean> b1= prodService.getProduct(prodBean.getProductId());
							for (ProductBean productBean : b1) {
								if (b1 != null) {
									System.out.println("Product Name :"+ productBean.getProductName());
									System.out.println("Product Id :" + productBean.getProductId());
								} else {
									System.err.println("No such Contracts Present :( 	");
								}
							}
						} catch (SchedulerExceptions e) {
							System.err.println(e.getMessage());

						}
						break;

					case 3: 
						c2 = 'n';
						break;			
					case 4:
						HomeForestry.mainHomeForestry();
					
					default:
						System.err.println("Invalid choice :");
						break;
					}	
				}
				break;

			case 3: 
				char d3 = 's';
				while(d3 =='s') {
					int ch4 = 0;
					char d4 = 'y';
					while( d4 == 'y') {
						System.out.println("------CUSTOMERS-----");
						System.out.println("Enter 1 : Get All Customers\nEnter 2 : Search Customers\nEnter 3 : Back\nEnter 4 : Home");
						String v1 = sc.next();
						if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
							 ch4 = Integer.parseInt(v1);
							 d4 ='n';
						}else {
							System.out.println("Enter only integers:");
						}
					}

					switch (ch4) {
					case 1:
						try {
						ArrayList<CustomerBean> b2 = custService.getAllCust();
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

					case 2:
						char d5 = 'y';
						while( d5 == 'y') {
							System.out.println("Enter the Customer id: ");
							String v1 = sc.next();
							if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
								int v22 = Integer.parseInt(v1);
								custBean.setCustomerId(v22);
								d4 ='n';
							}else {
								System.out.println("Enter only integers:");
							}
						}

						char d6 = 'y';
						while( d6 == 'y') {
							System.out.println("Enter the Telephone no: ");
							String v1 = sc.next();
							if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
								int v22 = Integer.parseInt(v1);
								custBean.setTelephone(v22);
								d6 ='n';
							}else {
								System.out.println("Enter only integers:");
							}
						}

						try {
						ArrayList<CustomerBean> b1 = custService.getCustomer(custBean.getCustomerId(), custBean.getTelephone());
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
							System.out.println(e.getMessage());
						}
						break;

					case 3: 
						d3 = 'k';
						break;

					case 4 :
						HomeForestry.mainHomeForestry();
					default:

						System.err.println("Invalid Choice :(");
						break;
					}
				}
				break;

			case 4: 
				char d4 = 's';
				while(d4 =='s') {
					
					int ch4 = 0;
					char d5 = 'y';
					while( d5 == 'y') {
						System.out.println("------LAND-----");
						System.out.println("Enter 1 : Get All Land Details\nEnter 2 : Search Land Details\nEnter 3 : Back\nEnter 4 : Home");
						String v1 = sc.next();
						if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
							 ch4 = Integer.parseInt(v1);
							d5 ='n';
						}else {
							System.out.println("Enter only integers:");
						}
					}
					switch (ch4) {
					case 1:
						try {
						List<LandBean> l2 = landServ.getAllLand();
						for (LandBean landBean : l2) {
							if (l2 != null) {
								System.out.println("Land Id :" +landBean.getLandId());
								System.out.println("Land Location :"+ landBean.getLocation());
								System.out.println("Land Owner :"+ landBean.getOwnerName());
								System.out.println("Land Acquired Date :"+ landBean.getDate());
								System.out.println("Land Value : "+ landBean.getValue());
							} 				}
						} catch (LandExceptions e) {
							System.err.println(e.getMessage());
						}
						break;
						
					case 2:
						char x2 = 'y';
						int b2 = 0;
						while( x2 == 'y') {
							System.out.println("Enter The Land Id :");
							String v1 = sc.next();
							if (Validation.isNumber1(v1)) {
								b2  = Integer.parseInt(v1);
								x2 ='n';
							}else {
								System.err.println("Enter only integers:");
							}
						}
						lBean.setLandId(b2);
						
						try {
						List<LandBean> l1 = landServ.searchLand(lBean.getLandId());
						for (LandBean landBean : l1) {
							if (l1 != null) {
								System.out.println("Land Id :" +landBean.getLandId());
								System.out.println("Land Location :"+ landBean.getLocation());
								System.out.println("Land Owner :"+ landBean.getOwnerName());
								System.out.println("Land Acquired Date :"+ landBean.getDate());
								System.out.println("Land Value : "+ landBean.getValue());
							} 
						}
						} catch (LandExceptions e) {
							System.err.println(e.getMessage());
						}
						break;
					
					case 3:
						d4 = 'a';
						break;
						
					case 4:
						HomeForestry.mainHomeForestry();
						break;
						
					default :
						System.err.println("Invalid Choice :(");
						break;
					}
				}
				break;
				
			case 5:
				a1 = 'n';
				break;
				
			case 6:
				HomeForestry.mainHomeForestry();
				break;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}
	}
}
