package ExcPropagation;

public class A {
	static void o() {
		try {
			B.n();
			
		} catch (ArithmeticException e) {
			System.out.println("Dont use zero @B"+e.getMessage());
		}
		
	}

}
