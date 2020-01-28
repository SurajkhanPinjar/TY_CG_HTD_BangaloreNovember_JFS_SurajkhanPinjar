package com.capgemini.forestrymanagementspringrest.dto;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "account_info")
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int adminId;

	@Column(name = "name")
	private String adminName;

	@Column(name = "password")
	private String adminPassword;
	
	@Column(name = "email")
	private String adminEmail;
	
	@Column(name = "roles")
	private String role;
}
