package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.ContractBean;
import com.capgemini.forestmanagement.exception.ContractsExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;
import com.capgemini.forestmanagement.main.MainHome;

public class ContractMain{

	public static  ContractDao dao= Factory.objDao();
	public static void contractMain(){

		Scanner sc= new Scanner(System.in);
		char a = 'y';
		while(a == 'y') {
			int ch=0;
			char shh1 = 'y';
			while( shh1 == 'y') {
				System.out.println("Enter 1 : Add Contract \nEnter 2 : Delete Contract \nEnter 3 : Show Contracts \nEnter 4 : Show all Contracts \nEnter 5 : Back \nEnter 6 : Home ");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					ch = Integer.parseInt(v1);
					shh1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}	


			switch (ch) {
			case 1:	

				ContractBean cont = new ContractBean();
				char chh2 = 'y';
				while( chh2 == 'y') {
					System.out.println("Enter the Contract No: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						cont.setContractNo(v22);
						chh2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}

				char chh3 = 'y';
				while( chh3 == 'y') {
					System.out.println("Enter the Customer id: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						cont.setCustomerId(v22);
						chh3 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}

				char chh4 = 'y';
				while( chh4 == 'y') {
					System.out.println("Enter the Product id: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						cont.setProdId(v22);
						chh4 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}

				char chh5 = 'y';
				while( chh5 == 'y') {
					System.out.println("Enter the Haulier id: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						cont.setHaulierId(v22);
						chh5 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}

				char b3 = 'y';
				while(b3 == 'y') {
					System.out.println("enter the Delivery Date (dd/mm/yyyy) : ");
					String cadd3 = sc.next();
					if (!Validation.isValidDate(cadd3)) {
						b3 = 'n';
						cont.setDeliveryDate(cadd3);;				
					}else {
						System.err.println("Enter currect date Format!!!!");
					}
				}
				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("Enter the Delivery Day : ");
					String cadd3 = sc.next();
					if (Validation.isValidDay(cadd3)) {
						b4 = 'n';
						cont.setDeliveryDay(cadd3);;				
					}else {
						System.err.println("Enter currect day Format!!!!");
					}
				}

				char chh6 = 'y';
				while( chh6 == 'y') {
					System.out.println("Enter the Quantity: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						cont.setQty(v22);
						chh6 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}


				try {
					if(dao.addContract(cont)) {
						System.out.println("Add Successfully");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				} 
				break;



			case 2:
				ContractBean contr = new ContractBean();

				char chh7 = 'y';
				while( chh7 == 'y') {
					System.out.println("Enter the Product id to delete: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						contr.setProdId(v22);
						chh7 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}

				try {
					if(dao.deleteContract(contr.getProdId())) {
						System.out.println("Contract deleted...");
					}
				} catch (ContractsExceptions e) {
					System.err.println(e.getMessage());
				} 
				break;


			case 3:
				ContractMain.showContract();
				break;

			case 4:
				ContractMain.showAllContract();
			case 5:
				a = 'n';
				break;

			case 6 :
				MainHome.mainHome();
			default:
				System.err.println("Invalid Choice :( ");
				break;
			}
		}
	}


	public static void showContract() {
		ContractBean contr2 = new ContractBean();

		System.out.println("The Details:");
		try {
			java.util.List<ContractBean> b = dao.showContract(contr2);
			for (ContractBean contractBean : b) {
				if (b != null) {
					System.out.println("Contract No is :"+contractBean.getContractNo());
					System.out.println("Contract "+ contractBean.getCustomerId());
					System.out.println("Delivery Date :"+contractBean.getDeliveryDate());
					System.out.println("Deliver Day :"+contractBean.getDeliveryDay()); 
					System.out.println("Hailier Id :"+contractBean.getHaulierId()); 
					System.out.println("Product Id :"+contractBean.getProdId()); 
					System.out.println("Quantity :"+contractBean.getQty()); 
					System.out.println("----------------------------");
				}
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
		}

	}


	public static void showAllContract() {
		List<ContractBean> list1 = new ArrayList<ContractBean>();
		try {

			list1 = dao.showAllContract();
			for (ContractBean contractBean : list1) {
				if (list1 != null ) {
					System.out.println("Contract No :" + contractBean.getContractNo());
					System.out.println("Customer Id :"+ contractBean.getCustomerId());
					System.out.println("Product Id :" +contractBean.getProdId());
					System.out.println("Delivery Date :" +contractBean.getDeliveryDate());
					System.out.println("Delivery Day :"+contractBean.getDeliveryDay());
					System.out.println("Haulier Id :"+contractBean.getHaulierId());
					System.out.println("Product Id :"+contractBean.getProdId());
					System.out.println("Quantity :"+contractBean.getQty());
					System.out.println("----------------------");
				} 
			}
		} catch (ContractsExceptions e) {
			System.err.println(e.getMessage());
		}
	}
}
