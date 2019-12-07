package ThrowThrows;

public class D {
	
	static void p() throws ClassNotFoundException {
		Class.forName("A");
	}

}
