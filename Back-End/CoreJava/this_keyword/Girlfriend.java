package ThisKeyword;

public class Girlfriend {

	String name;
	String company;
	double salary;
	
	public Girlfriend( String name, String company, double  salary) {
		this.name=name;
		this.company=company;
		this.salary=salary;
	
	}
	
	void gfDetails() {
		System.out.println("name is "+name+ " company is "+company+" salary is "+salary);
	}
}
