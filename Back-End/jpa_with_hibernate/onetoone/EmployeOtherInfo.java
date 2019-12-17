package com.capgemini.jpahibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Data
@Table (name = "emp_oth_info")
public class EmployeOtherInfo {
	@Id
	@Column
	private int id;
	@Column
	private int pan;
	@Column
	private String mname;
	@Column
	private String fname;
	@Exclude
	@OneToOne(cascade=CascadeType.ALL )
	private EmployeeInfo employeeInfo;
	
}
