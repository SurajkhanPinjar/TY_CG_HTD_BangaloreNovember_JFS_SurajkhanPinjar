
public class ExceptionA {
public static void main(String[] args) {
	
	System.out.println("Main Starts");
	
	try {
		Class c1= Class.forName("erson");
		System.out.println("person executed");
	} 
	catch (ClassNotFoundException e) {
		
		System.out.println("Class not found");
		
		
	}
	
	System.out.println("main Ends");
	
}
}
