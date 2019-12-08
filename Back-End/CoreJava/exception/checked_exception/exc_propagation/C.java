package ExcPropagation;

public class C {
	static void m() {
		try {
			System.out.println(10/0);
			
		} catch (ArithmeticException a) {
				System.out.println("@a"+a.getMessage());
				throw a;
		}
	}

}
