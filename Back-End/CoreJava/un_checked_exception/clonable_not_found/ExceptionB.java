package ClonableNotFound;

public class ExceptionB {
public static void main(String[] args) {
	System.out.println("main Started");
	Student s1=new Student();
	try {
		Class c1= Class.forName("erson");
		Object o1=s1.clone();
		System.out.println("Object is cloned");

	} catch (CloneNotSupportedException e) {
		System.out.println("clone is not supported");
		
	}
	catch(ClassNotFoundException c)
	{
		System.out.println("The class is not found");
	}
	
	System.out.println("Main ends");
}
}
