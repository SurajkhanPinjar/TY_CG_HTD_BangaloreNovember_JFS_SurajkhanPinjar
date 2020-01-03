package com.capgemini.forestry.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.controller.CustomerController;
import com.capgemini.forestry.controller.HomeForestry;
import com.capgemini.forestry.controller.Validation;
import com.capgemini.forestry.exception.CustomerExceptions;
import com.capgemini.forestry.factory.Factory;

public class CustomerDaoImpl implements CustomerDao {
	FileReader reader;
	Properties prop;
	CustomerBean bean = Factory.getCustBean();
	Scanner sc = new Scanner(System.in); 

	public CustomerDaoImpl() {
		try {
			reader = new FileReader("customer.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addCustomer(CustomerBean bean1) {

		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), 
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addquery"))){
			pstmt.setInt(1, bean1.getCustomerId());
			pstmt.setString(2, bean1.getCustomerName());
			pstmt.setString(3, bean1.getStreetAdd1());
			pstmt.setString(4, bean1.getStreetAdd2());
			pstmt.setString(5, bean1.getTown());
			pstmt.setInt(6, bean1.getPostalCode());
			pstmt.setString(8, bean1.getEmail());
			pstmt.setLong(7, bean1.getTelephone());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Customer Id Already Present  :(");
		}
		throw new CustomerExceptions("Customer Cannot be Added");

	}

	@Override
	public boolean deleteCustomer(int customerId, long telephone) {
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, customerId );
			pstmt.setLong(2, telephone);
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Customer Cannot be Deleted :(");
		}
		throw new CustomerExceptions("Enter Valid Customer Id");
		
	}

	@Override 
	public boolean modifyCustomer(int customerId) {
		char m = 'y';
		while(m == 'y') {
			char s1 = 'y';
			int choice = 0;
			while( s1 == 'y') {
				System.out.println("Enter Choice to Modify :");
				System.out.println("Enter 1 : Customer Name\nEnter 2 : Customer Street Address 2\nEnter 3 : Customer Street Address 2\n"
						+ "Enter 4 : Customer Town\nEnter 5 : Customers postalcode\nEnter 6 : Telephone \nEnter 7 : email id\n"
						+ "Enter 8 : Back\nEnter 9 : Home");
				String v1 = sc.next();
				if (Validation.isNumber1(v1)) {
					choice  = Integer.parseInt(v1);
					s1 ='n';
				}else {
					System.err.println("Enter only integers:");
				}
			}
			switch(choice)	{
			case 1:
				char c1 = 'y';
				while(c1 == 'y') {
					System.out.println("enter the customer name");
					String cname = sc.next();
					if (Validation.isStringOnlyAlphabet(cname)) {
						c1 = 'n';
						bean.setCustomerName(cname);

					}else {
						System.out.println("Enter only Alphabets!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("cust-modify"))) {

					pstmt.setString(1, bean.getCustomerName());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//				e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 2:
				char a2 = 'y';
				while(a2 == 'y') {
					System.out.println("enter the Street Address 1");
					String cadd1 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd1)) {
						a2 = 'n';
						bean.setStreetAdd1(cadd1);				
					}else {
						System.out.println("Enter only Alphabets!!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("add1-modify"))) {

					pstmt.setString(1, bean.getStreetAdd1());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//				e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 3:
				char a3 = 'y';
				while(a3 == 'y') {
					System.out.println("enter the Street Address 2");
					String cadd1 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd1)) {
						a3 = 'n';
						bean.setStreetAdd2(cadd1);				
					}else {
						System.out.println("Enter only Alphabets!!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("add2-modify"))) {

					pstmt.setString(1, bean.getStreetAdd2());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//		e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 4:
				char a4 = 'y';
				while(a4 == 'y') {
					System.out.println("enter the Town..");
					String cadd2 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd2)) {
						a4 = 'n';
						bean.setTown(cadd2);				
					}else {
						System.out.println("Enter only Alphabets!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("town-modify"))) {

					pstmt.setString(1, bean.getTown());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//		e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 5:
				char ch2 = 'y';
				int s2 = 0;
				while( ch2 == 'y') {
					System.out.println("Enter The Postal code:");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						s2 = Integer.parseInt(v1);
						ch2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				bean.setPostalCode(s2);

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("post-modify"))) {

					pstmt.setInt(1, bean.getPostalCode());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//		e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 6:
				char ch3 = 'y';
				int s3 = 0;
				while( ch3 == 'y') {
					System.out.println("Enter The Telephone:");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						s3 = Integer.parseInt(v1);
						ch3 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				bean.setTelephone(s3);
				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("tel-modify"))) {

					pstmt.setLong(1, bean.getTelephone());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//		e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 7:
				char a5 = 'y';
				while(a5 == 'y') {
					System.out.println("enter the Email: ");
					String cadd3 = sc.next();
					if (Validation.isValid(cadd3)) {
						a5 = 'n';
						bean.setEmail(cadd3);				
					}else {
						System.err.println("Email currect Format!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("email-modify"))) {

					pstmt.setString(1, bean.getEmail());
					pstmt.setInt(2, customerId);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					//		e.printStackTrace();
					System.err.println("Please Enter Valid Id");
				}
				
				break;
			case 8:
				CustomerController.custControl();
				break;
			
			case 9:
				HomeForestry.mainHomeForestry();
				break;
			
			default :
				System.err.println("Invalid Choice :(");
				break;
			}
		}
		return true;
	}

	@Override
	public ArrayList<CustomerBean> getCustomer(int customerId, long telephone) {
		ArrayList<CustomerBean> a = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {

			pstmt.setInt(1, customerId);
			pstmt.setLong(2, telephone);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomerBean bean1 = new CustomerBean();
				bean1.setCustomerId(rs.getInt(1));
				bean1.setCustomerName(rs.getString(2));
				bean1.setStreetAdd1(rs.getString(3));
				bean1.setStreetAdd2(rs.getString(4));
				bean1.setTown(rs.getString(5));
				bean1.setPostalCode(rs.getInt(6));
				bean1.setTelephone(rs.getLong(7));
				bean1.setEmail(rs.getString(8));
				a.add(bean1);
				return a;
			}

		} catch (Exception e) {
			System.out.println("not Found ");
		}
		throw new CustomerExceptions("Customer Cannot be Found\nEnter Valid Customer Id");
		
	}

	@Override
	public ArrayList<CustomerBean> getAllCust() {
		ArrayList<CustomerBean> a = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));

				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {


			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomerBean bean1 = new CustomerBean();
				bean1.setCustomerId(rs.getInt(1));
				bean1.setCustomerName(rs.getString(2));
				bean1.setStreetAdd1(rs.getString(3));
				bean1.setStreetAdd2(rs.getString(4));
				bean1.setTown(rs.getString(5));
				bean1.setPostalCode(rs.getInt(6));
				bean1.setTelephone(rs.getLong(7));
				bean1.setEmail(rs.getString(8));
				a.add(bean1);
				return a;
			}

		} catch (Exception e) {
			System.out.println("Not Found ");
		}
		throw new CustomerExceptions("Customer Not Present");
	}

}
