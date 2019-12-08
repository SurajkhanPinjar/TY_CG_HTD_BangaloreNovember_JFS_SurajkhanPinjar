package Typecasting;

public class TestImplicite {

	public static void main(String[] args) {
		PrimitiveImplicite p1= new PrimitiveImplicite();
		p1.detailsImplicite();
		System.out.println("------------------------------");
		PrimitiveExplicite p2=new PrimitiveExplicite();
		p2.detailss();
	}
}
