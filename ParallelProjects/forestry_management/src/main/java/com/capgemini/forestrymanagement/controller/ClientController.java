package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Client;
import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.exception.ClientExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ClientServices;


public class ClientController {
	public static void mainClientController() {
		Scanner sc = new Scanner(System.in);

		Client cbean = Factory.getClient();
		ClientServices serv = Factory.getClientService();

		System.out.println("-----Login client -----");
		char d1 = 'y';
		while( d1 == 'y') {
			System.out.println("Enter the Client id: ");
			String v1 = sc.next();
			if (Validation.isNumber(v1)) {
				int v22 = Integer.parseInt(v1);
				cbean.setClientId(v22);
				d1 ='n';
			}else {
				System.out.println("Enter only integers:");
			}
		}

		System.out.println("Enter The Password");
		cbean.setClientPassword(sc.next());
		try {
			
		if(serv.loginClient(cbean.getClientId(), cbean.getClientPassword())){
			System.out.println("Login Successfully\n");
			
			int cc = 0;
			char d2 = 'y';
			while( d2 == 'y') {
				System.out.println("----Welcome you Client----");
				System.out.println("Enter 1 : Contracts\nEnter 2 : Products\nEnter 3 : Customer\nEnter 4 : Back\nEnter 5 : Home");
				String v1 = sc.next();
				if (Validation.isNumber(v1)) {
					cc = Integer.parseInt(v1);
					d1 ='n';
				}else {
					System.out.println("Enter only integers:");
				}
			
				switch(cc) {

				case 1 :
					char c2 = 'y';
					while(c2=='y') {
						System.out.println("------Products-----");
						System.out.println("Enter 1 : Get All Contracts\nEnter 2 : Search Contracts\nEnter 3 : Back\nEnter 4 : Home");
						int ch2 = sc.nextInt();

						switch (ch2) {
						case 1:
							ContractorController.getAllContract();
							break;

						case 2 :
							ContractorController.searchContract();
							break;
						
						case 3:
							c2 = 'n';
							break;
						case 4:
							HomeForestry.mainHomeForestry();
							break;
						default :
							System.err.println("Invalid Choice ");
						}
					}
					break;

				case 2:	
					ProductController.productController();
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
		}} catch (ClientExceptions e) {
			System.err.println(e.getMessage());
		}
		
//		} else {
//			System.err.println("Login Failed\nEnter Valid Credentials");
//			ClientController.mainClientController();
//		}
	} 

}


