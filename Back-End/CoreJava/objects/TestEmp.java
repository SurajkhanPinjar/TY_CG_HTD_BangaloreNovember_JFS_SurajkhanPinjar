package Objects;

public class TestEmp {
	public static void main(String[] args) {
		Emp e1=new Emp(111, "khan");
		Emp e2=new Emp(111, "khan");
		Emp e3=new Emp(112, "KKhan");
		System.out.println(e1.equals(e2));
		System.out.println(e1==e2);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
	}

}
