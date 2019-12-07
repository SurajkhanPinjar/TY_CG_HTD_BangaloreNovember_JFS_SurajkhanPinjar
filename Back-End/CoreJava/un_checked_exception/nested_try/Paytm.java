package nestedTry;

public class Paytm {
	IRCTC i1;

	public Paytm(IRCTC i1) {
		super();
		this.i1 = i1;
	}
	
	
	void bookTickets() {
		try {
			i1.confirmTicket();
			System.out.println("Ticket Confirmed");
		} catch (ClassNotFoundException c) {
			System.out.println("Ticket not Confirmed");
			
		}
	}

}
