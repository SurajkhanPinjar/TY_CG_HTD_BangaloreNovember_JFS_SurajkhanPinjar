package CustonUnChecked.practice;

public class Boy {
	public static void main(String[] args) {
		School s1=new School();
		System.out.println("Main Starts...");
		
		try {
			s1.age(6);
		} catch (AgeLimitException e) {
			System.out.println(e.getMsg());
		}
		System.out.println("Main Ends....");
	}

}
