package com.capgemini.forestry.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class ContractorBean implements Serializable {
	private int contractNo;
	private int customerId;
	private int prodId;
	private int haulierId;
	private String deliveryDate;
	private String deliveryDay;
	private int qty;
	
	

}
