package CustumExc;

public class SBIatm {
	public static void main(String[] args) {
		System.out.println("Main Starts");
		ATMSim a1=new ATMSim();
		try {
			a1.withDraw(41000);
			
		} catch (DayLimitExc e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Main Ends");
		
	}

}
