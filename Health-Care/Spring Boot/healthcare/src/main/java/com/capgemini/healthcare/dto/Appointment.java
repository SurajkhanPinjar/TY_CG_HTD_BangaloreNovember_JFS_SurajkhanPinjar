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
public class Appointment {
	
	@Id
	@Column (name = "id")
	@GeneratedValue
	private int appointmentId;
	
	@Column 
	private String centerId;

	@Column
	private String centerName;
	
	@Column 
	private int userId;
	
	@Column
	private String userName;
	
	@Column
	private int testId;
	
	@Column
	private String testName;
	
	@Column
	private String date;
	
	@Column 
	private String time;
	
	@Column
	private String status;
	
}
