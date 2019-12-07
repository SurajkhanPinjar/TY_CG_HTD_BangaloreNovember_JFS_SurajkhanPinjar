package com.capgemini.access.pack2;

import com.capgemini.access.pack1.Student;

public class TestStudent extends Student {

	protected TestStudent(String name) {  //child class calls the super constructor
		super(name);
		
	}
	
	void detailsStudent() {
		System.out.println("The student name is "+ studName);
	}
	
	public static void main(String[] args) {
		TestStudent s2=new TestStudent("KhanSuraj"); // we are not suppose to create the super class object.
		s2.detailsStud();
	}

}
