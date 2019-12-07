package Typecasting;

public class PrimitiveImplicite {
	byte b=10;
	short s=b;
	int i=s;
	long l=i;
	float f=l;
	double d=l;
	
	void detailsImplicite() {
		System.out.println("The Byte value is:"+b);
		System.out.println("the Short Value is :"+s);
		System.out.println("The int value is:"+i);
		System.out.println("the long Value is :"+l);
		System.out.println("The Float value is:"+f);
		System.out.println("the double Value is :"+d);
	}
	

}
