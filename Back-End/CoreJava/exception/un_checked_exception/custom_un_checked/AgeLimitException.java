package CustonUnChecked;

public class AgeLimitException extends Exception {
	String msg="Age should be more than 18";

	public AgeLimitException(String msg) {
		super();
		this.msg = msg;
	}
	
	public AgeLimitException() {
	
	}
	
	public String getMessage() {
		return this.msg;
		
	}

}
