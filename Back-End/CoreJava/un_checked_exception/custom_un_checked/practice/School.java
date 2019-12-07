package CustonUnChecked.practice;

public class School {
	void age(int a) throws AgeLimitException {
//		if(a<5) {
//			throw new AgeLimitException();
//		}else {
//			System.out.println("allow for school....");
//		}
		
		if(a<18) {
			throw new AgeLimitException();
		}else {
			System.out.println("Allow for college  :) ");
		}
	}

}
