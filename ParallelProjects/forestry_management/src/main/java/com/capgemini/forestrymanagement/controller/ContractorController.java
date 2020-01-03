package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Contracts;
import com.capgemini.forestrymanagement.exception.ContractsExceptions;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ContractServices;


public class ContractorController {

	public static Contracts bean = Factory.getContracts();
	public static ContractServices serv = Factory.getContractServImpl();

	public static void contractorContr() {
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
					if (Validation.isNumber1(v1) || Validation.isStringOnlyAlphabet(v1)) {
						ch6 ='n';
						bean.setQuantity(v1);
					}else {
						System.err.println("Enter only integers:");
					}
				}	

				try {
					if(serv.addContract(bean)) {
						System.out.println("Add Successfully");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				} 

				break;

			case 2:
				char ch7 = 'y';
				int c7 = 0;
				while( ch7 == 'y') {
					System.out.println("Enter Contract id to delete: ");
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
					if(serv.deleteContract(bean.getContractNo())){
						System.out.println("Successfully deleted");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				} 
				break;

			case 3:
				ContractorController.searchContract();
				break;

			case 4:
				ContractorController.getAllContract();
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

	public static void searchContract() {
		Scanner sc = new Scanner(System.in);
		char ch8 = 'y';
		int c8 = 0;
		while( ch8 == 'y') {
			System.err.println("Enter Contract no:");
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
		Contracts b1 = serv.getContract(bean.getContractNo());
			if (b1 != null ) {
				System.out.println("Contract no :"+ b1.getContractNo());
				System.out.println("Customer Id : "+ b1.getContractNo());
				System.out.println("Product id  :"+ b1.getProdId());
				System.out.println("Haulier Id : "+ b1.getHaulierId());
				System.out.println("Delivery Date :"+ b1.getDeliveryDate());
				System.out.println("Delivery Day : "+ b1.getDeliveryDay());
				System.out.println("Quantity :" + b1.getQuantity());

			}

		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
			ContractorController.contractorContr();
		}

	}
	
	public static void getAllContract() {
		Scanner sc = new Scanner(System.in);
		
		try {
		ArrayList<Contracts> b2 = serv.getAllContract();
			for (Contracts contract : b2) {
				if (b2 != null) {
					System.out.println("Contract no :"+ contract.getContractNo());
					System.out.println("Customer Id : "+ contract.getCustomerId());
					System.out.println("Product id  :"+ contract.getProdId());
					System.out.println("Haulier Id : "+ contract.getHaulierId());
					System.out.println("Delivery Date :"+ contract.getDeliveryDate());
					System.out.println("Delivery Day : "+ contract.getDeliveryDay());
					System.out.println("Quantity :" + contract.getQuantity());
					System.out.println("-----------------------");
				}
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
			ContractorController.contractorContr();
		}
	}

}
