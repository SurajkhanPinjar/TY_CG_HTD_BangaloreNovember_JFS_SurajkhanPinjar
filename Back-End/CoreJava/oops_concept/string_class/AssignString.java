
public class AssignString {
	public static void main(String[] args) {
		String a="Surajkhan";
		System.out.println(a.concat(" king"));  //Concatination
		System.out.println(a.codePointAt(3));	//Code Point ?
		System.out.println(a.compareTo("f")); //Compare
		System.out.println(a.contains("s"));
		System.out.println(a.contentEquals("Surajkhan")); // sequence should be same
//		System.out.println(a.copyValueOf("S"));
		System.out.println(a.indexOf("S"));
		System.out.println(a.indexOf("j", 2));
		System.out.println(a.intern());		//Returns a canonical representation for the string object.
		System.out.println(a.isEmpty());	//Returns true if, and only if, length() is 0.
		
		
		
	}

}
