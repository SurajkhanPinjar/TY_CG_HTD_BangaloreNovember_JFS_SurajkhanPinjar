package com.capgemini.forestry.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestry.bean.AdminBean;
import com.capgemini.forestry.bean.ClientBean;
import com.capgemini.forestry.bean.CustomerBean;
import com.capgemini.forestry.exception.ClientExceptions;
import com.capgemini.forestry.factory.Factory;
import com.capgemini.forestry.factory.Factory1;

public class ClientDaoImpl implements ClientDao {
	FileReader reader;
	Properties prop;
	ClientBean bean = Factory1.getClBean();

	public ClientDaoImpl() {
		try {
			reader=new FileReader("client.properties");
			prop=new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
        e.printStackTrace();
		}
	}
	
	@Override
	public boolean addClient(ClientBean bean) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("insertquery"))){
			pstmt.setInt(1, bean.getClientId());
			pstmt.setString(2, bean.getClientName());
			pstmt.setString(3, bean.getClientPass());
			
			int count=pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			} 
		}catch (Exception e) {
			throw new ClientExceptions("Client Account Cannot be Added\nClient Id Already Existed");
		}
		return false;
	}

	@Override
	public boolean loginClient(int clientid, String clientpass) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPass"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("loginquery"))){
			pstmt.setInt(1, clientid);
			pstmt.setString(2, clientpass);
			 ResultSet rs=pstmt.executeQuery();
			 ClientBean user1 = new ClientBean();
			 while(rs.next()) {
				 user1.setClientId(rs.getInt(1));
				 user1.setClientPass(rs.getString(3));
				
				 System.err.println(user1.getClientId());
				 if(user1.getClientId()==clientid || user1.getClientPass()==clientpass){
					 return true;
					 
				 } 
			 }
		} catch (Exception e) {
			System.err.println("Invalid Credentials");
		}
		throw new ClientExceptions("Login Failed");
	}



	@Override
	public List<ClientBean> searchClient(int clientid) {
		List< ClientBean> a = new ArrayList<ClientBean>();
		
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query"))) {
				pstmt.setInt(1, clientid);
				ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ClientBean bean1 = new ClientBean();
				bean1.setClientId(rs.getInt(1));
				bean1.setClientName(rs.getString(2));
				
				a.add(bean1);
			}
			return a;

		} catch (Exception e) {
			System.err.println("Client Cannot be Found");
		}
		throw new ClientExceptions("Enter Valid Client Id");
	}



	@Override
	public List<ClientBean> getAllClient() {
		ArrayList<ClientBean> a = new ArrayList<ClientBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"), prop.getProperty("dbPass"));
				
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {

			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ClientBean bean1 = new ClientBean();
				bean1.setClientId(rs.getInt(1));
				bean1.setClientName(rs.getString(2));
				a.add(bean1);
			}
			return a;

		} catch (Exception e) {
			System.err.println("No Clint Present");
		}
		throw new ClientExceptions("No Client Account Present");
	
	}



	@Override
	public boolean deleteClient(int clientid, String clientpass) {
		try( Connection conn =  DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPass"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {

			pstmt.setInt(1, clientid );
			pstmt.setString(2, clientpass);
			int i = pstmt.executeUpdate();
			if(i==1) {
				return true;
			}

		} catch (Exception e) {
			System.err.println("Something Went wrong  :(");
		}
		throw new ClientExceptions("Client Cannot be Deleted");
	}

}
