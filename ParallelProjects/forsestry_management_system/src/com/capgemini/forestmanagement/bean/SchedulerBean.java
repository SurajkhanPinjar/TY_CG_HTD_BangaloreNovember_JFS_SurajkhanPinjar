package com.capgemini.forestmanagement.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class SchedulerBean implements Serializable {
	private int schedId;
	private String schedName;
	private String schedMail;
	private String schedPassword;

}
