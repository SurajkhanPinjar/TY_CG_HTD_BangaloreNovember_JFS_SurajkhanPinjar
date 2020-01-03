package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.dto.Customer;
import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ContractServices;
import com.capgemini.forestrymanagement.services.CustomerService;
import com.capgemini.forestrymanagement.services.LandServices;
import com.capgemini.forestrymanagement.services.ProductServices;


public class Schedular {
	private static ContractServices contractServices = Factory.getContractServImpl();
	private static Contracts contrBean = Factory.getContracts();
	private static ProductServices prodService = Factory.getProductServImpl();
	private static Product prodBean = Factory.getProduct();
	
	private static CustomerService custService = Factory.getCustomerServImpl();
	private static Customer custBean = Factory.getCustomer();
	private static LandServices landServ = Factory.getLandService();
	private static Land lBean = Factory.getLand();
	
	public static void mainSchedular() {

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
						ProductController.getAllProducts();
						break;

					case 2 :
						 ProductController.searchProduct();
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
						if (Validation.isNumber(v1)) {
							 ch4 = Integer.parseInt(v1);
							 d4 ='n';
						}else {
							System.out.println("Enter only integers:");
						}
					}

					switch (ch4) {
					case 1:
						CustomerController.getAllCustomer();
						break;

					case 2:
						CustomerController.searchCustomer();
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
						if (Validation.isNumber(v1)) {
							 ch4 = Integer.parseInt(v1);
							d5 ='n';
						}else {
							System.out.println("Enter only integers:");
						}
					}
					switch (ch4) {
					case 1:
						LandController.getAllLands();
						break;
						
					case 2:
						LandController.searchLand();
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
