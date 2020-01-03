package com.capgemini.forestry.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.exception.LandExceptions;
import com.capgemini.forestry.factory.Factory1;
import com.capgemini.forestry.services.LandServices;

public class LandController {
	public static void landController() {
		LandServices lserv = Factory1.getLandServImpl();
		LandBean lbean = Factory1.getLandBean();
		Scanner sc = new Scanner(System.in);
		int choice = 0 ;
		
		while(true) {
			char chhh1 = 'y';
			while( chhh1 == 'y') {
				System.out.println("----LAND PAGE----");
				System.out.println("Enter 1 : Add Land Details \nEnter 2 : Delete Land details\nEnter 3 : Modify Land Details\n"
						+ "Enter 4 : Search Land Details\nEnter 5 : All Land Details\nEnter 6 : Back\nEnter 7 : Home");
				String v1 = sc.next();
				
				if (Validation.isNumber1(v1)) {
				  choice = Integer.parseInt(v1);
					chhh1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
			
			switch (choice) {
			case 1:
				char s1 = 'y';
				int d1 = 0;
				while( s1 == 'y') {
					System.out.println("Enter The Land Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						d1  = Integer.parseInt(v1);
						s1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				lbean.setLandId(s1);
				
				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("Enter the Land Location :");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b4 = 'n';
						lbean.setLocation(cadd3);
					}else {
						System.out.println("Enter Only Alphabates !!!!");
					}
				}
				
				
				char s2 = 'y';
				int d2 = 0;
				while( s2 == 'y') {
					System.out.println("Enter the Land Value In Rs/- :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						d2  = Integer.parseInt(v1);
						s2='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				lbean.setValue(s2);

				char b5 = 'y';
				while(b5 == 'y') {
					System.out.println("Enter The Land Owner Name :");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b5 = 'n';
						lbean.setOwnerName(cadd3);
					}else {
						System.out.println("Enter only Alphabates!!!!");
					}
				}
				
				char b9 = 'y';
				while(b9 == 'y') {
					System.out.println("Enter The Acquired  Date (DD/MM/YYYY) : ");
					String cadd3 = sc.next();
					if (Validation.isValidDate(cadd3)) {
						b9 = 'n';
						lbean.setDate(cadd3);
					}else {
						System.err.println("Enter Date Format  it should be in DD/MM/YYYY!!!!");
					}
				}
				
				
				try {
					if (lserv.addLand(lbean)) {
						System.out.println("Added Successfully :)");
					}
				} catch (LandExceptions e1) {
					System.err.println(e1.getMessage());
				} 
				break;

			case 2 :
				char a1 = 'y';
				int z1 = 0;
				while( z1 == 'y') {
					System.out.println("Enter The Land Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						z1  = Integer.parseInt(v1);
						a1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				lbean.setLandId(z1);
				
				try {
					if(lserv.deleteLand(lbean.getLandId())) {
						System.out.println("Deleted Successfully :)");
					}
				} catch (LandExceptions e1) {
					System.err.println(e1.getMessage());
				}  
				break ;
			
			case 3:
				char x1 = 'y';
				int b1 = 0;
				while( x1 == 'y') {
					System.out.println("Enter The Land Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						b1  = Integer.parseInt(v1);
						x1 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				lbean.setLandId(b1);
				
				try {
					if(lserv.modifyLand(lbean.getLandId() )) {
						System.out.println("Successfully Modified");
					}
				} catch (LandExceptions e1) {
					System.err.println(e1.getMessage());
				}
				break ;
			
			case 4:
				char x2 = 'y';
				int b2 = 0;
				while( x2 == 'y') {
					System.out.println("Enter The Land Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						b2  = Integer.parseInt(v1);
						x2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				lbean.setLandId(b2);
				
				try {
				List<LandBean> l1 = lserv.searchLand(lbean.getLandId());
				for (LandBean landBean : l1) {
					if (l1 != null) {
						System.out.println("Land Id :" +landBean.getLandId());
						System.out.println("Land Location :"+ landBean.getLocation());
						System.out.println("Land Owner :"+ landBean.getOwnerName());
						System.out.println("Land Acquired Date :"+ landBean.getDate());
						System.out.println("Land Value : "+ landBean.getValue());
					} 
				}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			
			case 5:
				try {
				List<LandBean> l2 = lserv.getAllLand();
				for (LandBean landBean : l2) {
					if (l2 != null) {
						System.out.println("Land Id :" +landBean.getLandId());
						System.out.println("Land Location :"+ landBean.getLocation());
						System.out.println("Land Owner :"+ landBean.getOwnerName());
						System.out.println("Land Acquired Date :"+ landBean.getDate());
						System.out.println("Land Value : "+ landBean.getValue());
					} 				}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				}
				break;
			
			case 6:
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
