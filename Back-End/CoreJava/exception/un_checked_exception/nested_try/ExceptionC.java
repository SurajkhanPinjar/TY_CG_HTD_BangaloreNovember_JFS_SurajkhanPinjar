package nestedTry;

public class ExceptionC {
	public static void main(String[] args) {
		
		Employee e1=new Employee();
		try {
			Object o1=e1.clone();
			System.out.println("Clone is done");
			try {
				Class c1=Class.forName("Employee");
				
			} catch (ClassNotFoundException e) {
				System.out.println("CLass not found");
				

			}
				
		} catch (CloneNotSupportedException e) {
			System.out.println("clone is not support");
			
		}
		System.out.println("Main ends");
		
		
	}

}
