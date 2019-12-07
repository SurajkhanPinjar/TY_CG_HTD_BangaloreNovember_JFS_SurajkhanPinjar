
public class TestBNullPointer {
	void write() {
		String s1=null;
		try {
			
			System.out.println("the length of string is "+ s1.length());	
		}
		catch (NullPointerException e) {
			System.out.println("Dont deal with null value");
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Main Starts");
		TestBNullPointer t1=new TestBNullPointer();
		t1.write();
		System.out.println("Main Ends");
	}

}
