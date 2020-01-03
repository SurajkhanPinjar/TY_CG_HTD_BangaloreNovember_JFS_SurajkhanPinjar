package com.capgemini.forestry.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.exception.ClientExceptions;
import com.capgemini.forestry.exception.ProductExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.factory.Factory1;
import com.capgemini.forestry.services.ClientSevices;
import com.capgemini.forestry.services.ProductServices;

public class ClientController {
	public static void mainClientController() {
		Scanner sc = new Scanner(System.in);
		ClientBean cbean = Factory1.getClBean();
		ClientSevices serv = Factory1.getClServ();
		ProductBean b = Factory.getProdBean();
		ProductServices servp = Factory.getProdServ();
		
		System.out.println("-----Login client -----");
		char d1 = 'y';
		while( d1 == 'y') {
		System.out.println("Enter the Client id: ");
		String v1 = sc.next();
		if (com.capgemini.forestry.controller.Validation.isNumber(v1)) {
			int v22 = Integer.parseInt(v1);
			cbean.setClientId(v22);
			d1 ='n';
		}else {
			System.out.println("Enter only integers:");
		}
		}
		
		System.out.println("Enter The Password");
		cbean.setClientPass(sc.next());
		
		try {
		
		if(serv.loginClient(cbean.getClientId(), cbean.getClientPass())){
			System.out.println("Login Successfully\n");
			
			char s = 'x';
			while (s == 'x') {
			System.out.println("----Welcome you Client----");
			System.out.println("Enter 1 : Contractor\nEnter 2 : Products\nEnter 3 : Customer\nEnter 4 : Back\nEnter 5 : Home");
			int cc = sc.nextInt();
			switch(cc) {
			
			case 1 :
				ContractorController.contractorContr();		
				break;
			
			case 2:	
				char c2 = 'y';
				while(c2=='y') {
				System.out.println("------Products-----");
				System.out.println("Enter 1 : Get All Products\nEnter 2 : Search Products\nEnter 3 : Back\nEnter 4 : Home");
				int ch2 = sc.nextInt();
				switch (ch2) {
				case 1:
					
					try {
						ArrayList<ProductBean> b2= servp.getAllProduct();
						for (ProductBean productBean : b2) {
							if (b2 != null) {
								System.out.println("User Name :"+ productBean.getProductName());
								System.out.println("User Id :" + productBean.getProductId());
								System.out.println("-------------------------");
							} 
						}
					} catch (ProductExceptions e) {
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
						b.setProductId(v22);
						d3 ='n';
					}else {
						System.out.println("Enter only integers:");
					}
					}
					
					try {
						ArrayList<ProductBean> b1= servp.getProduct(b.getProductId());
						for (ProductBean productBean : b1) {
							if (b1 != null) {
								System.out.println("User Name :"+ productBean.getProductName());
								System.out.println("User Id :" + productBean.getProductId());
							} 
						}
					} catch (ProductExceptions e) {
						System.err.println(e.getMessage());
					}
					break;
				
				case 3:
					CustomerController.custControl();
					break;
					
				case 4: 
					c2 = 'n';
					break;			
					
				case 5:
					HomeForestry.mainHomeForestry();
				default:
					System.err.println("Invalid choice :");
					break;
				}	
				}
				break;

		case 3:	
			CustomerController.custControl();
			break;
			
		case 4: 
			s = 'y';
			break;
			
		case 5: 
			HomeForestry.mainHomeForestry();
			break;
			
		default:
			System.err.println("Invalid Choice");
			break;
			}
			}
		}
		
		} catch (ClientExceptions e) {
			System.err.println(e.getMessage());
			ClientController.mainClientController();
		}
			
	
	}

}
