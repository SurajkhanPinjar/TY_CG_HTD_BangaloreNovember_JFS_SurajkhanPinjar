package com.capgemini.forestrymanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClientBean implements Serializable {
	private int clientId;
	private String clientName;
	private String clientPassword;
	private String role;

}
