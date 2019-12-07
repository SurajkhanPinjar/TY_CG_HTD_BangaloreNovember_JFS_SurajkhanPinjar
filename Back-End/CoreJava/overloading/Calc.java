package Overloading;

public class Calc {
	int add(int a) {
		return a+a;
	}
	
	int add(int a, int b) {
		return a+b;
		
	}
	
	double add(double c) {
		return c;
	}
	
 static void  mul(int a) {
		System.out.println("Sum of a"+a);
		
	}
	
	static void mul(int a, int b) {
		System.out.println("The sum of A nd B "+(a+b));
	}
	

}
