package ConstOverloading;

public class StudentC {
	String Sname;
	int Sage;
	
	public StudentC() {
	
	}
	
	StudentC(String name, int age){
		Sname=name;
		Sage=age;
	}
	
	void detailsStud() {
		System.out.println("name is "+ Sname+" age is "+Sage);
	}
}
