package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class ContractBean  implements Serializable{
	private int contractNo;
	private int customerId;
	private int prodId;
	private int haulierId;
	private String deliveryDate;
	private String deliveryDay;
	private int qty;
	
	
	
	

}
