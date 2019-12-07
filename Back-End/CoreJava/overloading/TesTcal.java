package Overloading;

public class TesTcal {
	public static void main(String[] args) {
		Calc c=new Calc();
		int r1=c.add(10);
		System.out.println(r1);
		
		int r2=c.add(20, 30);
		System.out.println(r2);
		 
		double r3=c.add(10.12);
		System.out.println(r3);
		
		Calc.mul(10);
		Calc.mul(20, 30);
		
	}

}
