package com.capgemini.forestry.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.controller.HomeForestry;
import com.capgemini.forestry.controller.LandController;
import com.capgemini.forestry.controller.Validation;
import com.capgemini.forestry.exception.LandExceptions;
import com.capgemini.forestry.factory.Factory1;

public class LandDaoImpl implements LandDao{

	FileReader reader;
	Properties prop;
	LandBean b1 = Factory1.getLandBean();
	Scanner sc = new Scanner(System.in); 

	public LandDaoImpl() {
		try {
			reader = new FileReader("land.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));

		} catch (Exception e) {
			System.err.println("Driver Cannot be Loaded");
		}
	}
	@Override
	public boolean addLand(LandBean lbean) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), 
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addquery"))){
			pstmt.setInt(1, lbean.getLandId());
			pstmt.setString(2, lbean.getLocation());
			pstmt.setInt(3, lbean.getValue());
			pstmt.setString(4, lbean.getOwnerName());
			pstmt.setString(5, lbean.getDate());
		

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Cannot be Added :(");
		}
		
		throw new LandExceptions("Land Id Already Existed");
	}

	@Override
	public boolean deleteLand(int landid) {
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, landid );
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}


		} catch (Exception e) {
			System.err.println("Something Went wrong :(");
		}
			throw new LandExceptions("Land Id Cannot Be Deleted\nEnter Valid Land Id");

	}

	@Override
	public boolean modifyLand(int landid) {
		char m = 'y';
		while(m == 'y') {
			char s1 = 'y';
			int choice = 0;
			while( s1 == 'y') {
				System.out.println("Enter Choice to Modify :");
				System.out.println("Enter 1 : Location\nEnter 2 : Owner Name \nEnter 3 : Value in Rs/-\nEnter 4 : Acquired Date\nEnter 5 : Back\nEnter 6 : Home");
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
				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("enter the Land Location : ");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b4 = 'n';
						b1.setLocation(cadd3);				
					}else {
						System.out.println("Enter currect day Format!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loc-modify"))) {

					pstmt.setString(1, b1.getLocation());
					pstmt.setInt(2, landid);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					System.err.println("Please Enter Valid Id");
				}
				break;
			
			case 2:
				char b5 = 'y';
				while(b5 == 'y') {
					System.out.println("enter the Land Owner Name : ");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b5 = 'n';
						b1.setOwnerName(cadd3);				
					}else {
						System.out.println("Enter currect day Format!!!!");
					}
				}
				
				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("own-modify"))) {

					pstmt.setString(1, b1.getOwnerName());
					pstmt.setInt(2, landid);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					System.err.println("Please Enter Valid Id");
				}
				break;
			
			case 3:
				char d = 'y';
				int s4 = 0;
				while( d == 'y') {
					System.out.println("Enter Land Value in Rs/- : ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
					  s4 = Integer.parseInt(v1);
						d ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}
				b1.setValue(s4);
				
				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("val-modify"))) {

					pstmt.setInt(1, b1.getValue());
					pstmt.setInt(2, landid);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					System.err.println("Please Enter Valid Id");
				}
				break;
			
			case 4:
				//				date
				break;
			
			case 5:
				LandController.landController();
				break;
			
			case 6:
				HomeForestry.mainHomeForestry();
			
			}
			}
		 throw new LandExceptions("Modification Failed\nEnter Valid Land ID");
	}
	@Override
	public List<LandBean> searchLand(int landid) {
		List<LandBean> a = new ArrayList<LandBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {

			pstmt.setInt(1, landid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LandBean bean1 = new LandBean();
				bean1.setLandId(rs.getInt(1));
				bean1.setLocation(rs.getString(2));
				bean1.setOwnerName(rs.getString(3));
				bean1.setDate(rs.getString(4));
				bean1.setValue(rs.getInt(5));
				a.add(bean1);
				return a;
			}
			
		}
		 catch (Exception e) {
			System.out.println("Something went Wrong :(");
		}
		throw new LandExceptions("Land Details Cannot be Found\nEnter valid Land id");
	}

	@Override
	public List<LandBean> getAllLand() {
		List<LandBean> a = new ArrayList<LandBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				LandBean bean1 = new LandBean();
				bean1.setLandId(rs.getInt(1));
				bean1.setLocation(rs.getString(2));
				bean1.setOwnerName(rs.getString(3));
				bean1.setDate(rs.getString(4));
				bean1.setValue(rs.getInt(5));
				a.add(bean1);
				return a;
			}
			
		}
		 catch (Exception e) {
			System.out.println("Something went Wrong :(");
		}
		throw new LandExceptions("No Land Details Present");
		
	}
}
