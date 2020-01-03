package com.capgemini.forestry.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.exception.ProductExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.services.ProductServices;

public class ProductController {

	public static void productContr() {

		char a = 'y';
		ProductBean b = Factory.getProdBean();
		ProductServices serv = Factory.getProdServ();
		Scanner sc = new Scanner(System.in);
		while(a == 'y') {
			char s1 = 'y';
			int choice = 0;
			while( s1 == 'y') {
				System.out.println("Enter 1 : Add Product\nEnter 2 : Delete Product\nEnter 3 : Modify Product\nEnter 4 : Get Product\nEnter 5 : Get All Products\nEnter 6 : Back\nEnter 7 : Home");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					choice  = Integer.parseInt(v1);
					s1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}	

			switch (choice) {
			case 1:
				char a1 = 'y';
				while(a1 == 'y') {
					System.out.println("enter the product name");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						a1 = 'n';
						b.setProductName(cname);				
					}else {
						System.out.println("Enter only Alphabets!!!!");
					}
				}

				char s2 = 'y';
				int c2 = 0;
				while( s2 == 'y') {
					System.out.println("Enter The Prod Id: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c2  = Integer.parseInt(v1);
						s2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				b.setProductId(c2);

				try {
					if(serv.addProduct(b)) {
						System.out.println("Product Added :)");
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				}		
				break;

			case 2: 
				char s3 = 'y';
				int c3 = 0;
				while( s3 == 'y') {
					System.out.println("Enter Product id to delete: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c3  = Integer.parseInt(v1);
						s3 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				b.setProductId(c3);

				try {
					if(serv.deleteProduct(b.getProductId())) {
						System.out.println("Product Successfully deleted");
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				}

			case 3:
				char s4 = 'y';
				int c4 = 0;
				while( s4 == 'y') {
					System.out.println("Enter User id to Update Products: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c4  = Integer.parseInt(v1);
						s4 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				b.setProductId(c4);


				char s5 = 'y';
				while(s5 == 'y') {
					System.out.println("Enter The Prod Name to be Update: ");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						s5 = 'n';
						b.setProductName(cname);				
					}else {
						System.out.println("Enter only Alphabets!!!!");
					}
				}

				try {
					if(serv.modifyProduct(b.getProductId(), b.getProductName())) {
						System.out.println("Successfully updated");
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				} 
			case 4:
				char s6 = 'y';
				int c6 = 0;
				while( s6 == 'y') {
					System.out.println("Enter The Prod Id to Get details:");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c6  = Integer.parseInt(v1);
						s6 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				b.setProductId(c6);
				
				try {
					ArrayList<ProductBean> b1= serv.getProduct(b.getProductId());
					for (ProductBean productBean : b1) {
						if (b1 != null) {
							System.out.println("User Name :"+ productBean.getProductName());
							System.out.println("User Id :" + productBean.getProductId());
						} 
					}
				} catch (ProductExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break;

			case 5: 
				ArrayList<ProductBean> b2= serv.getAllProduct();
				try {
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

			case 6:	
				a = 'n';
				break;
			case 7:
				HomeForestry.mainHomeForestry();

			default: System.err.println("Invalid Choice :(");
			break;

			}

		}
	}
}
