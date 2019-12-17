package com.capgemini.jpahibernate.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.jpahibernate.onetoone.EmployeeInfo;

import lombok.Data;

@Entity
@Data
@Table (name = "experience_info")
public class Experience_Info {
	@Id
	@Column
	private int expid;
	@Column
	private String company;
	@Column
	private int duration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eid")
	private EmployeeInfo employeeInfo;

}
