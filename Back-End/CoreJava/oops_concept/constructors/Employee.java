package Constructors;

public class Employee {
	String empname;
	int empage;
	double empsalary;
	
	public Employee(String name, int age, double salary) {
		
		empname=name;
		empage=age;
		empsalary=salary;
		
		
	}
	
	void details() {
		System.out.println("the name: "+empname+" age is :"+empage+" the salary is: "+empsalary);
	}

}
