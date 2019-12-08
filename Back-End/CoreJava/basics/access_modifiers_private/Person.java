package AccessModPrivate;

public class Person {
	private String name;
	
	private void detailName() {
		System.out.println("int in");
	}

	Person(String name) {
		this.name=name;
	}
}
