package com.capgemini.jpahibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name ="emp_info")
@Data
public class EmployeeInfo {
	@Id
	@Column
	private int eid;
	@Column
	private String ename;
	@Column
	private String email;
	@Column
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "employeeInfo" )
	private EmployeOtherInfo eoi;
	
	
}
