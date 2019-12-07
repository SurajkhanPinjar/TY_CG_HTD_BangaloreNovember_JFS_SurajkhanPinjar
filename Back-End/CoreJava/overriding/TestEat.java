package Overriding;

public class TestEat {
	public static void main(String[] args) {
		Cats c=new Cats();
		c.eat();
		
		Lions l =new Lions();
		l.eat();
		
		Animals a=new Lions();
		a.eat();
		
		Animals a1=new Cats();
		a1.eat();
	}

}
