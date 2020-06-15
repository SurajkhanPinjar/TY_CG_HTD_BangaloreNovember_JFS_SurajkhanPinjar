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
public class DiagnosticCenter {
	
	@Id
	@Column 
	private String centerId;
	
	@Column
	private String centerName;
	
	
}
