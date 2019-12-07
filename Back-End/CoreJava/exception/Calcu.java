
public class Calcu {
	void divide(int a, int b) {
		System.out.println("Divide started");
		
		try {					// always we must use the try and catch blocks to handle the exceptions.
		System.out.println(a/b);
		}
		catch(ArithmeticException e) {
			System.out.println("Dont divide by zero ");
		}
		
		
		
		System.out.println("Divide method ended");
	}
}
