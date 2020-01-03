package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class ClientBean implements Serializable{
	private int cId;
	private String cName;
	private String cPass;
	
}
