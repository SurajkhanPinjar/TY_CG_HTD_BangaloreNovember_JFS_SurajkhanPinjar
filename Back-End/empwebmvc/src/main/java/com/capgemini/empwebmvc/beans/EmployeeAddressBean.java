package com.capgemini.empwebmvc.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name ="employee_address_info")
public class EmployeeAddressBean {

	@Id
	@Column
	@GeneratedValue
	private int id;
	
	@Column
	private String addType;
	
	@Column
	private String  address1;
	
	@Column
	private String address2;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eid")
	
	private EmployeeBean bean;
}
