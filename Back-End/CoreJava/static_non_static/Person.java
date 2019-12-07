package StaticNNonStatic;

public class Person {

	static int age;
	String name;
	
	void personDetails() {
		System.out.println("the name is"+ " "+ name+" and age is "+age);
		personDetailsStatic();
	}
	
	static void personDetailsStatic() {
		
		System.out.println(age);
	}
}
