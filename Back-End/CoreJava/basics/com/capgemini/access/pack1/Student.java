package com.capgemini.access.pack1;

public class Student {
	protected String studName;
	
	protected void detailsStud() {
		System.out.println("The Student name is "+studName);
	}

	protected Student(String name) {
		this.studName=name;
	}
}
