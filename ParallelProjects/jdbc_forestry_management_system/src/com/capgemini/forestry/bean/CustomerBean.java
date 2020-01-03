package com.capgemini.forestry.bean;

import lombok.Data;

@Data
public class CustomerBean {
	private int customerId;
	private String customerName;
	private String streetAdd1;
	private String streetAdd2;
	private String town;
	private int postalCode;
	private String email;
	private long telephone;


}
