package TrainPayTM;

public class IRCTC {
	void confirmTicket() throws ClassNotFoundException {
		try {
			Class.forName("nestedTry.Paytm");
			System.out.println("Ticket is confirmed");
		} catch (ClassNotFoundException e) {
			System.out.println("class is not Found");
			throw e;
			

		}
	}

}
