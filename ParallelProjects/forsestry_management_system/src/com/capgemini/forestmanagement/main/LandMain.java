package com.capgemini.forestmanagement.main;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.LandBean;
import com.capgemini.forestmanagement.dao.LandDao;
import com.capgemini.forestmanagement.exception.LandExceptions;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;

public class LandMain {
	public static LandDao dao = Factory.getLandDao();
	public static void mainLand() {
		Scanner sc = new Scanner(System.in);
		int choice = 0 ;

		while(true) {
			char chhh1 = 'y';
			while( chhh1 == 'y') {
				System.out.println("----LAND PAGE----");
				System.out.println("Enter 1 : Add Land Details \nEnter 2 : Delete Land details \nEnter 3 : Modify Land Details \nEnter 4 : Search Land Details \nEnter 5 : Get All Land Details \nEnter 6 : Back \nEnter 7 : Home " );
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
				LandBean lbean = new LandBean();

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
						System.err.println("Enter Only Alphabates !!!!");
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
						System.err.println("Enter only Alphabates!!!!");
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
					if (dao.addLand(lbean)) {
						System.out.println("Added Successfully :)");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				} 
				break;

			case 2 :
				LandBean lbean1 = new LandBean();

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
				lbean1.setLandId(z1);

				try {
					if(dao.deleteLand(lbean1.getLandId())) {
						System.out.println("Deleted Successfully :)");
					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
					} 
				break ;

			case 3:
				LandBean lbean2 = new LandBean();

				char a2 = 'y';
				int z2 = 0;
				while( z2 == 'y') {
					System.out.println("Enter The Land Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						z2  = Integer.parseInt(v1);
						a2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				lbean2.setLandId(z2);

				try {
					if (dao.modifyLand(lbean2.getLandId())) {
						System.out.println("Update Successfully");

					}
				} catch (LandExceptions e) {
					System.err.println(e.getMessage());
				} 

				break ;

			case 4:
				searchLand();
				break;

			case 5:
				getAllLand();
				break;

			case 6:
				return;
			case 7 :	
				MainHome.mainHome();
				break;

			default:
				System.err.println("Invalid Choice :(");
				break;
			}

		}

	}

	public static void searchLand( ) {
		Scanner sc = new Scanner(System.in);
		LandBean lbean3 = new LandBean();

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
		lbean3.setLandId(z1);


		try {
		List<LandBean> l1 = dao.searchLand(lbean3.getLandId());
			for (LandBean landBean : l1) {
				if (l1 != null) {
					System.out.println("Land Id	:" +landBean.getLandId());
					System.out.println("Land Location :"+ landBean.getLocation());
					System.out.println("Land Owner :"+ landBean.getOwnerName());
					System.out.println("Land Acquired Date :"+ landBean.getDate());
					System.out.println("Land Value :"+ landBean.getValue());
					System.out.println("----------------------------");
				} 

			}
		}
		catch (LandExceptions e) {
			System.err.println(e.getMessage());

		}
	}

	public static void getAllLand( ) {
		LandBean lbean4 = new LandBean();
		try {
		List<LandBean> l2 = dao.getAllLand();
			for (LandBean landBean : l2) {
				if (l2 != null) {
					System.out.println("Land Id	:" +landBean.getLandId());
					System.out.println("Land Location :"+ landBean.getLocation());
					System.out.println("Land Owner :"+ landBean.getOwnerName());
					System.out.println("Land Acquired Date	:"+ landBean.getDate());
					System.out.println("Land Value :"+ landBean.getValue());
					System.out.println("----------------------------");
				} 

			}

		} catch (LandExceptions e) {
			System.err.println(e.getMessage());
		}

	}
}
