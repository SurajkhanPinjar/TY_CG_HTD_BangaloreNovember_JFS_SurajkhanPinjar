package com.capgemini.springrest.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table (name = "employee_info")
public class EmployeeBean {
	
	@Id
	@Column
	@GeneratedValue
	private int eid ;
	
	@Column
	private String name;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column
	private String password;
	
	@Exclude
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bean")
	private List<EmployeeAddressBean > addressBeans;
	
	
}
