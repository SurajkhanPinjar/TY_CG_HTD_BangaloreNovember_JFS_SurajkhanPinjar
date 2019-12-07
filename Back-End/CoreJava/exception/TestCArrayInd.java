
public class TestCArrayInd {
	public static void main(String[] args) {
		System.out.println("Main Starts");
		int a1[] = new int[2];
		a1[0]=10;
		a1[1]=30;
		try {
			a1[2]=45;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("There is no size for further variables	");
		}
		
		
		System.out.println("main ends");
	}
}
