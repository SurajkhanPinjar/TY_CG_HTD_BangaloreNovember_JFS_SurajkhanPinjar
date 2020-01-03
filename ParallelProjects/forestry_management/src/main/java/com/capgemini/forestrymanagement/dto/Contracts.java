package com.capgemini.forestrymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "contract_info")
@Data
public class Contracts {
	
	@Id
	@Column (name = "contractno")
	private int contractNo;
	
	@Column (name = "customerid")
	private int customerId;
	
	@Column (name = "prodid")
	private int prodId;
	
	@Column (name = "haulierid")
	private int haulierId;
	
	@Column (name = "deliverydate")
	private String deliveryDate;
	
	@Column (name = "deliveryday")
	private String deliveryDay;
	
	@Column
	private String transportation;
	
	@Column 
	private String quantity;
	
	@Column
	private String status;
	
	

	
}
