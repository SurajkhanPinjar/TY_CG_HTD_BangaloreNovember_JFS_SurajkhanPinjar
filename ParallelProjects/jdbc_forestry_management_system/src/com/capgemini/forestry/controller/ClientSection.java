package com.capgemini.forestry.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.exception.ClientExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.factory.Factory1;
import com.capgemini.forestry.services.ClientSevices;
import com.capgemini.forestry.services.ContractorServices;
import com.capgemini.forestry.services.CustomerServices;
import com.capgemini.forestry.services.ProductServices;

public class ClientSection {
	public static void clientSection() {
		Scanner sc = new Scanner(System.in);
		ClientSevices serv = Factory.getClientServ();
		ClientBean cbean = Factory1.getClBean();

		char c1 = 'a';
		while(c1=='a') {

			int c=0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("Enter 1 : Add Client \nEnter 2 : Delete Client \nEnter 3 : Search Client \nEnter 4 : Get All Client\n"
						+ "Enter 5 : Modify Client\nEnter 6 : Back\nEnter 7 : Home");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					c = Integer.parseInt(v1);
					chh1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
			switch (c) {
			case 1:
				int c2=0;
				char chh2 = 'y';
				while( chh2 == 'y') {
					System.out.println("Enter The Client id");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c2 = Integer.parseInt(v1);
						chh2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				cbean.setClientId(c2);

				char a1 = 'y';
				while(a1 == 'y') {
					System.out.println("Enter The Client Name :");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						a1 = 'n';
						cbean.setClientName(cname);
					}else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char m2 = 'y';
				while(m2 == 'y') {
					System.out.println("Enter the Password:");
					String cadd3 = sc.next();
					int strength = Validation.calculatePasswordStrength(cadd3);
					System.out.println("Your Password Strength is :" +strength);
					if (strength == 10) {
						m2 = 'n';
						cbean.setClientPass(cadd3);				
					}else {
						System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 10 digits  "
								+ "1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}


				System.out.println("Enter The Password :");
				cbean.setClientPass(sc.next());

				try {
					if(serv.addClient(cbean)) {
						System.out.println("Client Added Successfully");
					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());
				} 
				break;

			case 2 :
				int c3=0;
				char chh3 = 'y';
				while( chh3 == 'y') {
					System.out.println("Enter The Client Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c3 = Integer.parseInt(v1);
						chh3 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				cbean.setClientId(c3);

				System.out.println("Enter The Client Password  :");
				cbean.setClientPass(sc.next());

				try {
					if(serv.deleteClient(cbean.getClientId(), cbean.getClientPass())) {
						System.out.println("Deleted Successfully");	

					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;


			case 3 :
				int c4=0;
				char chh4 = 'y';
				while( chh4 == 'y') {
					System.out.println("Enter The Client Id to Search");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c4 = Integer.parseInt(v1);
						chh4 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				cbean.setClientId(c4);

				try {
					List<ClientBean> list = serv.searchClient(cbean.getClientId()); 
					for (ClientBean clientBean : list) {

						if (list != null ) {
							System.out.println("Client Id :" + clientBean.getClientId());
							System.out.println("CLient Name :" + clientBean.getClientName());
							System.out.println("----------------------");

						} else {
							System.err.println("Client Not Found ");
						}
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4:
				
				try {
					List<ClientBean> list1 = serv.getAllClient();
					for (ClientBean clientBean : list1) {
						if (list1 != null ) {
							System.out.println("Client Id :" + clientBean.getClientId());
							System.out.println("CLient Name :"+ clientBean.getClientName());
							System.out.println("----------------------");
						} 
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Modify ");
				break;

			case 6 :
				return;

			case 7 :
				HomeForestry.mainHomeForestry();


			default:
				System.err.println("Invalid Choice :(");
				break;
			}



		}


	}
}
