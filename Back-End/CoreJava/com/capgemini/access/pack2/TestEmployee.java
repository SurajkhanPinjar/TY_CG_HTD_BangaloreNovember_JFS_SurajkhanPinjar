package com.capgemini.access.pack2;

import com.capgemini.access.pack1.Employee;

public class TestEmployee {
	public static void main(String[] args) {
		Employee e2=new Employee("suraj");  //constructor is not public bcz its in another package
		e2.deails; // details is not a public access modifier
	}

}
