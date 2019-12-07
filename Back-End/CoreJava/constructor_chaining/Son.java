package ConstChaning;

public class Son extends Father {
	
	String sname;
	int sage;
	
	Son(){
		super("khan",23);
		System.out.println("C");
	}
	
	Son(String name, int age){
		this();
		System.out.println("D");
	}

}
