package com.capgemini.forestrymanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagement.dto.Land;
import com.capgemini.forestrymanagement.factory.Factory;
import com.capgemini.forestrymanagement.services.LandServices;


public class LandController {

	private static LandServices lserv = Factory.getLandService();
	private static Land lBean = Factory.getLand();
	private static Scanner sc = new Scanner(System.in);

	public static void landController() {
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
				lBean.setLandId(s1);

				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("Enter the Land Location :");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b4 = 'n';
						lBean.setLocation(cadd3);
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
				lBean.setValue(s2);

				char b5 = 'y';
				while(b5 == 'y') {
					System.out.println("Enter The Land Owner Name :");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b5 = 'n';
						lBean.setOwnerName(cadd3);
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
						lBean.setDate(cadd3);
					}else {
						System.err.println("Enter Date Format  it should be in DD/MM/YYYY!!!!");
					}
				}


				if (lserv.addLand(lBean)) {
					System.out.println("Added Successfully :)");
				} else {
					System.err.println("Cannot be Added :(");
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
				lBean.setLandId(z1);

				if(lserv.deleteLand(lBean.getLandId())) {
					System.out.println("Deleted Successfully :)");
				} else {
					System.err.println("Enter Valid Id:(");
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
				lBean.setLandId(b1);

				if(lserv.modifyLand(lBean.getLandId() )) {
					System.out.println("Successfully Modified");
				}else {
					System.err.println("Please Enter Valid Land Id :  ");
				}

				break ;

			case 4:
				LandController.searchLand();
				break;

			case 5:
				LandController.getAllLands();
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
	
	public static void searchLand() {
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
		lBean.setLandId(b2);

		List<Land> l1 = lserv.searchLand(lBean.getLandId());
		try {
			for (Land Land : l1) {
				if (l1 != null) {
					System.out.println("Land Id :" +Land.getLandId());
					System.out.println("Land Location :"+ Land.getLocation());
					System.out.println("Land Owner :"+ Land.getOwnerName());
					System.out.println("Land Acquired Date :"+ Land.getDate());
					System.out.println("Land Value : "+ Land.getValue());
				} 
			}
		} catch (Exception e) {
			System.err.println("No such Lands present :(");
		}
		
	}
	
	
	public static void getAllLands() {
		List<Land> l2 = lserv.getAllLand();
		try {
			for (Land land : l2) {
				if (l2 != null) {
					System.out.println("Land Id :" +land.getLandId());
					System.out.println("Land Location :"+ land.getLocation());
					System.out.println("Land Owner :"+ land.getOwnerName());
					System.out.println("Land Acquired Date :"+ land.getDate());
					System.out.println("Land Value : "+ land.getValue());
				} 				}
		} catch (Exception e) {
			System.err.println("No  Lands present :(");
		}
	}
	
	
}
