package com.capgemini.forestrymanagementjdbc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SchedulerBean implements Serializable {
	private int schedulerId;
	private String schedulerName;
	private String schedulerPassword;
	private String role;
	

}
