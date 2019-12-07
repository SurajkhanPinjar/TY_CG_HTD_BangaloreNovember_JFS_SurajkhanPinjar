package StaticNNonStatic;

public class TestQspiders {
	
	public static void main(String[] args) {
		
		Qspiders BTM= new Qspiders();
		BTM.swipe();
		BTM.swipe();
		BTM.swipe();
		
		Qspiders BTR= new Qspiders();
		BTR.swipe();
		BTR.swipe();
		
		System.out.println(BTM.branchcount);
		System.out.println(BTR.branchcount);
		System.out.println(Qspiders.totalcount);
		
		
	}

}
