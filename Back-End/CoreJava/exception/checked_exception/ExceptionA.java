
public class ExceptionA {
	void exception (int a , String b) {
		
		
		
		
		try {
			System.out.println(500/a);
			
			try {
				System.out.println(b.length());
				
			}catch (NullPointerException e2) {
				System.out.println("Dont deal with null");
			}
		}
			catch (ArithmeticException e1) {
				System.out.println("Dont deal with zero");
			
			
		
	}
}
}
