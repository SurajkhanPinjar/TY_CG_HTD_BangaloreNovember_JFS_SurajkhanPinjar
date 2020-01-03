package com.capgemini.forestry.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestry.bean.ContractorBean;
import com.capgemini.forestry.controller.HomeForestry;
import com.capgemini.forestry.controller.Validation;
import com.capgemini.forestry.exception.ContractsExceptions;
import com.capgemini.forestry.factory.Factory;

public class ContractorDaoImpl implements ContractorDao {
	FileReader reader;
	Properties prop;
	static ContractorBean bean1 = Factory.getContrBean();
	Scanner sc = new Scanner(System.in); 

	public ContractorDaoImpl() {
		try {
			reader = new FileReader("contractor.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("Driver Cannot be Loaded");
		}
	}
	@Override
	public boolean addContractor(ContractorBean contractor) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), 
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addquery"))){
			pstmt.setInt(1, contractor.getContractNo());
			pstmt.setInt(2, contractor.getCustomerId());
			pstmt.setInt(3, contractor.getProdId());
			pstmt.setInt(4, contractor.getHaulierId());
			pstmt.setString(5, contractor.getDeliveryDate());
			pstmt.setString(6, contractor.getDeliveryDay());
			pstmt.setInt(7, contractor.getQty());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Contract Id Already Exists  :(");
		}
		throw new ContractsExceptions("Contract cannot be Added");

	}

	@Override
	public boolean deleteContractor(int contractid) {
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, contractid );
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			System.err.println("Something Went wrong  :(");
		}
		throw new ContractsExceptions("Contract Cannot be Deleted");
	}

	@Override
	public ArrayList<ContractorBean> getContractor(int contractno) {
		ArrayList<ContractorBean> a = new ArrayList<ContractorBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {

			pstmt.setInt(1, contractno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bean1 = new ContractorBean();
				bean1.setContractNo(rs.getInt(1));
				bean1.setCustomerId(rs.getInt(2));
				bean1.setProdId(rs.getInt(3));
				bean1.setHaulierId(rs.getInt(4));
				bean1.setDeliveryDate(rs.getString(5));
				bean1.setDeliveryDay(rs.getString(6));
				bean1.setQty(rs.getInt(7));
				a.add(bean1);
				return a;
			}

		} catch (Exception e) {
			System.err.println("Cannot be Found");
		}
		throw new ContractsExceptions("Contract Cannot be Found\nEnter Valid Contractor Id");
	}
	@Override
	public ArrayList<ContractorBean> getAllContractor() {
		ArrayList<ContractorBean> a = new ArrayList<ContractorBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bean1 = new ContractorBean();
				bean1.setContractNo(rs.getInt(1));
				bean1.setCustomerId(rs.getInt(2));
				bean1.setProdId(rs.getInt(3));
				bean1.setHaulierId(rs.getInt(4));
				bean1.setDeliveryDate(rs.getString(5));
				bean1.setDeliveryDay(rs.getString(6));
				bean1.setQty(rs.getInt(7));
				a.add(bean1);
			}
			return a;

		} catch (Exception e) {
			System.out.println("Not Found ");
		}
		throw new ContractsExceptions("No Contracts Present");
		
	}


	@Override
	public boolean modifyContractor(int contractNo) {
		char m = 'y';
		while(m == 'y') {
			char s1 = 'y';
			int choice = 0;
			while( s1 == 'y') {
				System.out.println("Enter Choice to Modify :");
				System.out.println("Enter 1 : Haulier Id\nEnter 2 : Delivery Date\nEnter 3 : Delivery Day\nEnter 4 : Quantity\nEnter 5 : Back\nEnter 6 : Home");
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
				char s2 = 'y';
				int v2 = 0;
				while( s2 == 'y') {
					System.out.println("Enter Haulier Id :");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						v2  = Integer.parseInt(v1);
						s2 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				bean1.setHaulierId(v2);

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("hmodify"))) {

					pstmt.setInt(1, bean1.getHaulierId());
					pstmt.setInt(2, contractNo);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}

				} catch (Exception e) {
					System.err.println("Please Enter Valid Id");
				}
				break;

			case 2:
				System.out.println("Date");
				break;

			case 3:
				char b4 = 'y';
				while(b4 == 'y') {
					System.out.println("enter the Delivery Day : ");
					String cadd3 = sc.next();
					if (Validation.isStringOnlyAlphabet(cadd3)) {
						b4 = 'n';
						bean1.setDeliveryDay(cadd3);				
					}else {
						System.out.println("Enter currect day Format!!!!");
					}
				}

				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("day-modify"))) {

					pstmt.setString(1, bean1.getDeliveryDay());
					pstmt.setInt(2, contractNo);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}

				} catch (Exception e) {
					System.err.println("Please Enter day");
				}
				break;

			case 4:
				char ch6 = 'y';
				int c6 = 0;
				while( ch6 == 'y') {
					System.out.println("Enter the Quantity: ");
					String v1 = sc.next();
					if (Validation.isNumber1(v1)) {
						c6  = Integer.parseInt(v1);
						ch6 ='n';
					}else {
						System.err.println("Enter only integers:");
					}
				}	
				bean1.setQty(c6);
				
				try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
						prop.getProperty("dbPass"));
						PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("q-modify"))) {

					pstmt.setInt(1, bean1.getQty());
					pstmt.setInt(2, contractNo);
					int i = pstmt.executeUpdate();
					if(i==1) {
						return true;
					}else {
						return false;
					}

				} catch (Exception e) {
					System.err.println("Please Enter valid Id");
				}
				break;
				
			case 5:
				m = 's';
				break;
				
			case 6:
				HomeForestry.mainHomeForestry();
				
			default:
				System.err.println("Invalid Choice ");
				break;
			}


		}
		return false;
	}
}
