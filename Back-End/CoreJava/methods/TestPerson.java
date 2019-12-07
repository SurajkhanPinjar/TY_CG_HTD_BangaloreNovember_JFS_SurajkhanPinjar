package Methods;

public class TestPerson {
	public static void main(String[] args) {
		Person p=new Person();
		p.age=23;
		p.name="Khan";
		
		p.personDetails();
		
		Person p1=new Person();
		p1.initialize(23, "suraj");
		p1.personDetails();
		
	}

}
