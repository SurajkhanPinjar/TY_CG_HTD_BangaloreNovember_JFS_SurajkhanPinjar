package CustumExc;

public class DayLimitExc extends RuntimeException {
	String msg;

	public DayLimitExc() {
		
	}

	public DayLimitExc(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	
	
	
	

}
