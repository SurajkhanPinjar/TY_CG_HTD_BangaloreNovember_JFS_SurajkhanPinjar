package com.capgemini.healthcare.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Test {
	@Id
	@Column (name = "id")
	@GeneratedValue
	private int testId;
	
	@Column(unique = false)
	private String testName;
	
	@Column(unique = false)
	private String centerId;
	
}
