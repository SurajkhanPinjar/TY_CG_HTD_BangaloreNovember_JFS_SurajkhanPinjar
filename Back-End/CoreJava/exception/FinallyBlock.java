
public class FinallyBlock {
	public static void main(String[] args) {
		System.out.println("Main Starts");
		try {
			System.out.println(10/0);
		} catch (ArithmeticException e) {
			System.out.println("Dont deal with zero");
		} finally {
			System.out.println("Fianlly block is callled");
		}
		
		
		System.out.println("Main ends");
	}
}
