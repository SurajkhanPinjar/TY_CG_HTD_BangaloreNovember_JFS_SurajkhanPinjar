package SuperThisLOcalGLobal;

public class Cars extends Vehicle {
	int cost=1000;
	
	void detailCars() {
		int cost=100;
		System.out.println("the local variable cost is "+cost);
		System.out.println("THe global variable cost is "+ this.cost);
		System.out.println("The parent cost is "+super.cost);
	}

}
