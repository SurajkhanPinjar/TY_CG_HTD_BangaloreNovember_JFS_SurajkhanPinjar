
public class StringBuffBuild {
	public static void main(String[] args) {
		String s1=new String("John");
		System.out.println(s1.hashCode());
		s1=s1.concat("Cena");
		System.out.println(s1.hashCode());
		System.out.println("-------------------");
		StringBuffer s2=new StringBuffer("King");
		System.out.println(s2.hashCode());
		s2=s2.append("khan");
		System.out.println(s2.hashCode());
	}

}
