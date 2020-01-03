package com.capgemini.forestry.dao;

import java.io.DataOutput;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestry.bean.AdminBean;
import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.LandBean;
import com.capgemini.forestry.bean.SchedulerBean;
import com.capgemini.forestry.factory.Factory1;

public class SchedulerDaoImpl implements SchedulerDao{

	FileReader reader;
	Properties prop;
	SchedulerBean b1 = Factory1.getSchedBean();
	Scanner sc = new Scanner(System.in); 
	
	public SchedulerDaoImpl() {
		try {
			reader = new FileReader("scheduler.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			System.err.println("Driver Cannot be Loaded");
		}
	}
	
	@Override
	public boolean addScheduler(SchedulerBean sbean) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), 
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addquery"))){
			pstmt.setInt(1, sbean.getSchedulerId());
			pstmt.setString(2, sbean.getSchedulerName());
			pstmt.setString(3, sbean.getSchedulerPass());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			System.err.println("Scheduler Id Already Present");
			
			return false;
		}
	}

	@Override
	public boolean deleteScheduler(int schedulerId, String password) {
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, schedulerId );
			pstmt.setString(2, password);
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
		return false;
	}

	@Override
	public boolean loginScheduler(int schedulerId, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPass"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("login"))){
			pstmt.setInt(1, schedulerId);
			pstmt.setString(2, password);
			 ResultSet rs=pstmt.executeQuery();
			 SchedulerBean sBean = new SchedulerBean();
			 while(rs.next()) {
				 sBean.setSchedulerId(rs.getInt(1));
				 sBean.setSchedulerPass(rs.getString(3));
			 }
			 if(sBean.getSchedulerId() == schedulerId || sBean.getSchedulerPass() == password){
				 return true;
				 
			 } else {
				 System.err.println("Invalid Admin");
				 return false;
			 }
			 
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
		}
		
		return false;
	}

	@Override
	public List<SchedulerBean> getAllScheduler() {
		List<SchedulerBean> a = new ArrayList<SchedulerBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				SchedulerBean bean1 = new SchedulerBean();
				bean1.setSchedulerId(rs.getInt(1));
				bean1.setSchedulerName(rs.getString(2));
				a.add(bean1);
				return a;
				
			}
			
		}
		 catch (Exception e) {
			System.out.println("Something went Wrong :(");
		}
		return null;
	}

}
