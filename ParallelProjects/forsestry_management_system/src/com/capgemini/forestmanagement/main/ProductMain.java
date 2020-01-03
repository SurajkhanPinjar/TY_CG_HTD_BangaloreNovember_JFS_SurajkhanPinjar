package com.capgemini.forestmanagement.main;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ProductBean;
import com.capgemini.forestmanagement.dao.ProductDao;
import com.capgemini.forestmanagement.exception.ProductExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;

public class ProductMain {
	public static ProductDao daoo= Factory.prodImpl();

	public static void productMain() {
		Scanner sc= new Scanner(System.in);
		char s = 'y';
		while(s == 'y') {

			int ch=0;
			char shh1 = 'y';
			while( shh1 == 'y') {
				System.out.println("----PRODUCTS----");
				System.out.println("Enter 1 : Add Products \nEnter 2 : Delete Product \nEnter 3 : Modify Products \nEnter 4 : Get Products \nEnter 5 : Back\nEnter 6 : Home");
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
				ProductBean b=new ProductBean();
				System.out.println("----ADD PRODUCTS----");
				char ch1 = 'y';
				while( ch1 == 'y') {
					System.out.println("Enter the Prod Id");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						b.setProdId(v22);
						ch1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}

				}
				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("Enter the Product Name : ");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b4 = 'n';
						b.setProdName(cadd3);				
					}else {
						System.err.println("Enter currect Format!!!!");
					}
				}

				try {
					if(daoo.addProduct( b)) {
						System.out.println("Added Successfully..");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 2:
				ProductBean b1=new ProductBean();

				char chh1 = 'y';
				while( chh1 == 'y') {
					System.out.println("Enter the Prod Id");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						b1.setProdId(v22);
						chh1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}

				}

				try {
					if(daoo.deleteProduct(b1.getProdId())) {
						System.out.println("Deleted...");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 3: 
				ProductBean b2=new ProductBean();

				char chh2 = 'y';
				while( chh2 == 'y') {
					System.out.println("Enter the Prod Id to Modify");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						b2.setProdId(v22);
						chh2 ='n';
					}else {
						System.err.println("Enter only integers :");
					}

				}

				try {
					if(daoo.modifyProduct(b2.getProdId())) {
						System.out.println("Modify Successfully.. :)");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 4: 
				ProductBean b3=new ProductBean();

				char chh3 = 'y';
				while( chh3 == 'y') {
					System.out.println("Enter the Prod Id");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						int v22 = Integer.parseInt(v1);
						b3.setProdId(v22);
						chh3 ='n';
					}else {
						System.err.println("Enter only integers:");
					}

				}

				try {
					if(daoo.getProduct(b3.getProdId())) {
						System.out.println("---The Details are--");
					}
				} catch (ProductExceptions e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				s = 'n';
				break;

			default:
				System.err.println("Invalid Choice :( ");
				break;
			}
		}
	}

	public static void getProducts() {
		Scanner sc = new Scanner(System.in);
		ProductBean b3=new ProductBean();
		char chh3 = 'y';
		while( chh3 == 'y') {
			System.out.println("Enter the Prod Id");
			String v1 = sc.next();
			if (Validation.isNumber1(v1)) {
				int v22 = Integer.parseInt(v1);
				b3.setProdId(v22);
				chh3 ='n';
			}else {
				System.err.println("Enter only integers:");
			}

		}

		try {
			if(daoo.getProduct(b3.getProdId())) {
				System.out.println("---The Details are--");
			}
		} catch (ProductExceptions e) {
			System.err.println(e.getMessage());
		}
	}
}
