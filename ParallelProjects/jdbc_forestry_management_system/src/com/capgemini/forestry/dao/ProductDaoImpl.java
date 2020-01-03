package com.capgemini.forestry.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.annotation.processing.Filer;

import com.capgemini.forestry.bean.ProductBean;
import com.capgemini.forestry.exception.LandExceptions;
import com.capgemini.forestry.exception.ProductExceptions;
import com.mysql.jdbc.Statement;

public class ProductDaoImpl implements ProductDao {

	FileReader reader;
	Properties prop;
	ProductBean bean1;
	Scanner sc = new Scanner(System.in); 

	public  ProductDaoImpl() {
		try {
			reader = new FileReader("product.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
			

		} catch (Exception e) {
			System.err.println("Driver Not Loaded");
		}
	}

	@Override
	public boolean addProduct(ProductBean bean) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), 
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addquery"))){
			pstmt.setString(1, bean.getProductName());
			pstmt.setInt(2, bean.getProductId());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Went Wrong");
		}
		throw new ProductExceptions("Product Cannot be Added\nProduct Id Already Existed");
	}

	@Override
	public boolean deleteProduct(int productid) {
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, productid );
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong");
		}
		throw new ProductExceptions("Product Cannot be Deleted\nEnter Valid Product Id");
	}

	@Override
	public boolean modifyProduct(int productid, String productname) {
		
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("modify"))) {
			pstmt.setString(1, productname );
			pstmt.setInt(2, productid);
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
		throw new ProductExceptions("Modification Failed\nEnter Valid Product Id");
	}

	@Override
	public ArrayList<ProductBean> getProduct(int productid) {
		ArrayList<ProductBean> a = new ArrayList<ProductBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {

			pstmt.setInt(1, productid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bean1 = new ProductBean();
				bean1.setProductName(rs.getString(1));
				bean1.setProductId(rs.getInt(2));
				a.add(bean1);
				return a;
			}

		} catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
		throw new ProductExceptions("Product Cannot be Found\nEnter Valid Product Id");
	}

	@Override
	public ArrayList<ProductBean> getAllProduct() {
		ArrayList<ProductBean> a = new ArrayList<ProductBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {

			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bean1 = new ProductBean();
				bean1.setProductName(rs.getString(1));
				bean1.setProductId(rs.getInt(2));
				a.add(bean1);
				return a;
			}

		} catch (Exception e) {
			System.out.println("Somethin went wrong");
		}
		throw new ProductExceptions("No Products Present");
	}


}
