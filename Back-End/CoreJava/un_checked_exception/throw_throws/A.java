package ThrowThrows;

public class A {
	static void m() {
		
		try {
			B.n();
		} catch (ClassNotFoundException e) {
			System.out.println("Class is not Found");
			
			
		}
	}

}
