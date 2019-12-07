package Objects.GetClass;

public class TestAnima {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Dog d1=new Dog("Pink");
		Class c1=d1.getClass();
		
//		
		Dog d2=(Dog) c1.newInstance();
		System.out.println(c1);
		System.out.println(d2.name);
		
//		ForName
		
		Class c2=Class.forName("Dog");
		
	}

}
