package ConstOverloading;

public class TestStud {
	public static void main(String[] args) {
		StudentC s=new StudentC();
		
		s.detailsStud();
		StudentC s1=new StudentC("khan",23);
		s1.detailsStud();
	}

}
