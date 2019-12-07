package ThrowGoogleOla;

public class Ola {
	GoogleM g1;

	public Ola(GoogleM g1) {
		super();
		this.g1 = g1;
	}
	
	void find(String a) {
		try {
			g1.findLocation(a);
			
		} catch (NullPointerException e) {
			System.out.println("ola user Enter the location");
			
		}
	}
	

}
