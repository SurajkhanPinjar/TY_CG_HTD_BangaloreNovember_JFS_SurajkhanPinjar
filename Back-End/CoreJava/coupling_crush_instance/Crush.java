package CouplingCrushINst;

public class Crush {
	void recieve(Phone P) {
		if(P instanceof BasicSet) {
			System.out.println("Ty");
		}
		else if(P instanceof Oppo) {
			System.out.println("Ty sm");
		}
		else if (P instanceof OnePlus) {
			System.out.println("Ty dear");
			
		}
		else if (P instanceof Apple) {
			System.out.println("Love U");
			
		}
		else {
			System.out.println("Idiot");
		}
	}

}
