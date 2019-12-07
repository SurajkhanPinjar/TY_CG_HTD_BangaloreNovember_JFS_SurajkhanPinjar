
public class DemoMain {
	public static void main(String[] args) {
		Demo5 d1=new Demo5("Khan", 22);
		System.out.println(d1.hashCode());
		d1=new Demo5("suraj ", 23);
		System.out.println(d1.hashCode());
		int age=d1.getAge();
		String name = d1.getName();
		System.out.println("age is "+age);
		System.out.println("Name is "+ name);
	}
}
