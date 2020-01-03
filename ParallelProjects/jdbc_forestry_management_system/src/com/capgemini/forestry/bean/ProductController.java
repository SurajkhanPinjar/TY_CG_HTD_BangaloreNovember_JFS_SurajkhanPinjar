package com.capgemini.forestry.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.services.ProductServices;

public class ProductController {
	public static void main(String[] args) {
		ProductBean bean = new ProductBean();
		ProductServices serv = Factory.getProdServ();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Product \n1.Add Product\n2.Delete Product\n3.Modify Product\n4.Get Product");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
				System.out.println("Enter The Product Name:");
				bean.setProductName(sc.next());
				System.out.println("Enter The Prod Id: ");
				bean.setProductId(sc.nextInt());
				
				if(serv.addProduct(bean)) {
					System.out.println("Product Added :)");
				}else {
					System.err.println("Something went Wrong  :(");
				}
			
			break;
		case 4: 
			System.out.println("Enter Prod Id:");
			bean.setProductId(sc.nextInt());
			ProductBean bean1 = new ProductBean();

			ArrayList<ProductBean> b1 = serv.getProduct(bean.getProductId());
			if(b1 != null) {
				System.out.println("Prod Name: "+ bean1.getProductName());
				System.out.println("Prod Id: "+ bean1.getProductId());
			}else {
				System.err.println("Something Wrong :( ");
			}
			
			

		default:
			break;
		}
		
	}

}
