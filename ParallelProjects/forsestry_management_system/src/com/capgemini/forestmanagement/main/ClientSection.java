package com.capgemini.forestmanagement.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.bean.ProductBean;
import com.capgemini.forestmanagement.dao.ClientDao;
import com.capgemini.forestmanagement.dao.ContractMain;
import com.capgemini.forestmanagement.dao.ProductDao;
import com.capgemini.forestmanagement.dao.ProductDaoImpl;
import com.capgemini.forestmanagement.exception.ClientExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;


public class ClientSection {

	static ProductDao productDao = new ProductDaoImpl(); 
	public static ClientDao dao = Factory.clientIml();

	public static void clientSection() {
		Scanner sc = new Scanner(System.in);

		char c1 = 'a';
		while(c1 =='a') {

			int c=0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("Enter 1 : Add Client \nEnter 2 : Delete Client \nEnter 3 : Search Client \n"
						+ "Enter 4 : Get All Client\nEnter 5 : Modify Client\nEnter 6 : Back\nEnter 7 : Home");
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
				ClientBean cbean = new ClientBean();

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
				cbean.setCId(c2);

				char a1 = 'y';
				while(a1 == 'y') {
					System.out.println("Enter The Client Name :");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						a1 = 'n';
						cbean.setCName(cname);
					}else {
						System.err.println("Enter only Alphabets!!!!");
					}
				}

				char m1 = 'y';
				while(m1 == 'y') {
					System.out.println("Enter the Password:");
					String cadd3 = sc.next();
					int strength = Validation.calculatePasswordStrength(cadd3);
					System.out.println("Your Password Strength is :" +strength);
					if (strength == 10) {
						m1 = 'n';
						cbean.setCPass(cadd3);				
					}else {
						System.err.println("The Password Strength is not Strong :( \nThe Password Should contain min 8 digits  "
								+ "Atleast 1 Upper case,1 lower cases, 1 special charecter and integers :)");
					}
				}


				try {
					if(dao.addClient(cbean)) {
						System.out.println("Added Successfully");
					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());	
				} 
				break;

			case 2 :
				ClientBean cbean1 = new ClientBean();

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
				cbean1.setCId(c3);

				try {
					if(dao.deleteClient(cbean1.getCId())) {
						System.out.println("Deleted Successfully");	

					}
				} catch (ClientExceptions e1) {
					System.err.println(e1.getMessage());
				}  
				break;


			case 3 :
				ClientBean cbean2 = new ClientBean();

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
				cbean2.setCId(c4);

				List<ClientBean> list = new ArrayList<ClientBean>();
				try {
				list = dao.searchClient(cbean2.getCId()); 
					for (ClientBean clientBean : list) {

						if (list != null ) {
							System.out.println("Client Id	:" + clientBean.getCId());
							System.out.println("Client Name :"+ clientBean.getCName());
							System.out.println("----------------------");

						} 
					} 
				}catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}

				break;

			case 4:
				List<ClientBean> list1 = new ArrayList<ClientBean>();
				
				try {
					list1 =dao.getAllClient();
					for (ClientBean clientBean : list1) {
					if (list1 != null ) {
						System.out.println("Client Id :" + clientBean.getCId());
						System.out.println("Client Name :"+ clientBean.getCName());
						System.out.println("----------------------");

					} 

				} if(list1.isEmpty()) {

					System.err.println("No Clients Presents");
				}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				ClientBean cbean3 = new ClientBean();
				System.out.println("-----Modify----");

				int c5=0;
				char chh5 = 'y';
				while( chh5 == 'y') {
					System.out.println("Enter The Client Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c5 = Integer.parseInt(v1);
						chh5 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				cbean3.setCId(c5);

				try {
					if(dao.updateClient(cbean3.getCId())) {
						System.out.println("Successfully Updated");
					}
				} catch (ClientExceptions e) {
					System.err.println(e.getMessage());
				} 

				break;

			case 6 :
				c1 = 'n';
				return;

			case 7 :
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice :(");
				break;
			}
		}
	}

	
	public static void loginClient() {
		
		char a = 'y';
		while(a == 'y' ) {
			
		
		Scanner sc = new Scanner(System.in);
		ClientBean cbean4 = new ClientBean();

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
		cbean4.setCId(c3);

		System.out.println("Enter The Client PassWord");
		cbean4.setCPass(sc.next());
		try {
		if(dao.loginClient(c3, cbean4.getCPass())) {
			System.out.println("Client Login Successfully :)");

			int c=0;
			char chh1 = 'y';
			while( chh1 == 'y') {
				System.out.println("Enter 1 : Contracts \nEnter 2 :  Customers \nEnter 3 : Products \nEnter 4 : Back \nEnter 5 : Home ");
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
				ContractMain.contractMain();

				break;

			case 2 :
				CustomerMain.customerMain();
				break;

			case 3 :
				ProductMain.getProducts();
				break;

			case 4 :
				ClientMain.clientMain();

			case 5:
				MainHome.mainHome();

			default:
				System.err.println("Invalid Choice :(");
				break;
			}	


		} 

		} catch (ClientExceptions e) {
			System.err.println(e.getMessage());
		}
	}
	}

}
