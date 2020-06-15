package com.capgemini.healthcare.dto;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {

	@Id
	@Column 
	@GeneratedValue
	private int userId;
	
	@Column(name = "name")
	private String userName;
	
	@Column(name = "password")
	private String userPassword;

	@Column(name = "contactNo")
	private BigInteger contactNo;
	
	@Column(name = "email")
	private String userEmail;

	@Column(name = "role")
	private String userRole;
	
	


	
}
