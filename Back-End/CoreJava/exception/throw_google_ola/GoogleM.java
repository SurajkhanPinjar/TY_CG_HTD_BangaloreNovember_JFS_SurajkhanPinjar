package ThrowGoogleOla;

public class GoogleM {
	
	
	void findLocation(String loc) {
		try {
			loc.length();
			
		} catch (NullPointerException e) {
			System.out.println("google user insert location");
			throw e;
			
		}
	}

}
