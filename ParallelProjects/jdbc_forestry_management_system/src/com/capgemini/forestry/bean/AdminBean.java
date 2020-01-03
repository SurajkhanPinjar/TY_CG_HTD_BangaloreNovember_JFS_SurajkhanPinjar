package com.capgemini.forestry.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class AdminBean implements Serializable{
	private int adminId;
	private String adminName;
	private String password;
	private String email;
	

}
