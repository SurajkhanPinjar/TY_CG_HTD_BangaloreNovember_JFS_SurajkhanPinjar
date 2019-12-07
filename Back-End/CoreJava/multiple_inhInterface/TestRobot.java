package MultipleInhInterface;

public class TestRobot {
	public static void main(String[] args) {
		Moment m1=new Robot();
		
		m1.move();
		m1.talk();
		
		Sound s1=new Robot();
		s1.talk();
	}

}
