package MultipleInhInterface;

public class Robot  implements Moment, Sound{
	
	public void talk() {
		System.out.println("The robot talks");
	}
	
	public void move() {
		System.out.println("The robot will move");
	}

}
