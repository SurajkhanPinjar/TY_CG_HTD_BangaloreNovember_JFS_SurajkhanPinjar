package IIBnonStatic;

public class FValue {
	final int a;
	static final int PI;
	
	public FValue() {
	System.out.println("Constr is Called");
	}
	
	{
		System.out.println("IIB is Called");
		a=68;
		
	}
	
	static {
		System.out.println("Static IIB starts");
		PI=33;
		System.out.println(PI);
		
		
	}
	
	FValue(int b){
		System.out.println("Overloading");
	}
	
	
	

}
