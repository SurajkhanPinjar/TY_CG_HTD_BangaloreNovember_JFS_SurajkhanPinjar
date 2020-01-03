package com.capgemini.forestrymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Product;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.ProductServices;

public class ProductController {
	
	private static Product pro = Factory.getProduct();
	private static ProductServices serv = Factory.getProductServImpl();

	public static void productController() {
		Scanner sc = new Scanner(System.in);


		int c = 0;
		char aa = 'y';
		while(aa == 'y') {

				int s = 0;
				char s1 = 'y';
				while( s1 == 'y') {
					System.out.println("-------PRODUCTS------");
					System.out.println("Enter 1 : Add Products\nEnter 2 : Delete Products\nEnter 3 : Search Product\nEnter 4 : Modification\n5.Enter 5 : Get All Products\nEnter 6 : Back");
					String d1 = sc.next();

					if (com.capgemini.forestrymanagement.factory.Validation.isNumber1(d1)) {
						s = Integer.parseInt(d1);
						s1 ='n';
					}else {
						System.out.println("Enter only integers:");
					}
				}

				switch (s) {
				case 1:
					System.out.println("Enter The Prod Name :");
					pro.setProductName(sc.next());
					System.out.println("Enter The Prod Id :");
					pro.setProductId(sc.nextInt());

					if(serv.addProduct(pro)) {
						System.out.println("Added Successfully ");
					} else {
						System.out.println("Something Went Wrong");
					}

					break;

				case 2:
					System.out.println("Enter the Product id ");
					pro.setProductId(sc.nextInt());

					if(serv.deleteProduct(pro.getProductId())) {
						System.out.println("deleted Successfully");
					} else {
						System.out.println("Something Went Wrong");
					}
					break;

				case 3 :
					ProductController.searchProduct();
					break;
				case 4 :
					System.out.println("Enter The Product id :");
					pro.setProductId(sc.nextInt());
					System.out.println("Enter The Product name to be modify :");
					pro.setProductName(sc.next());

					if(serv.modifyProduct(pro.getProductId(), pro.getProductName())) {
						System.out.println("Modified Successfully");
					} else {
						System.out.println("Product modification error");
					}
					break;

				case 5 :
					ProductController.getAllProducts();
					break;

				default:
					break;
				}


		}//WHile
	}// End Of Main
	
	public static void searchProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the prod Id to search:");
		pro.setProductId(sc.nextInt());

		Product pr = serv.getProduct(pro.getProductId());
		if(pr != null )  {
			System.out.println("Product Name :" + pr.getProductName());
			System.out.println("Product Id :" + pr.getProductId());
			System.out.println("---------------------------");

		} else {
			System.out.println("No Elements Present ");
		}
		
	}
	
	public static void getAllProducts() {
		ArrayList<Product> pr1 = serv.getAllProduct();
		for (Product product : pr1) {
			if(product != null )  {
				
				System.out.println("Product Name :" + product.getProductName());
				System.out.println("Product Id :" + product.getProductId());
				System.out.println("---------------------------");
				
			} else {
				System.out.println("No Elements Present ");
			}
			
		}
		
		
	}

} 