package CustumExc;

public class ATMSim {
	void withDraw(double amt) {
		if(amt>4000) {
			throw new DayLimitExc("sorry");
		}
	}

}
