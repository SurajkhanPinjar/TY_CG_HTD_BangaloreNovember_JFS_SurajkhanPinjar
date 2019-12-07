
public class Array2 {
	public static void main(String[] args) {
		double d1[] = new double[4];
		d1[0]=10;
		d1[1]=11.22;
		d1[2]=11.222;
		
		for(int i=0; i<d1.length;i++)
		{
			System.out.println(d1[i]);
		}
		
		
//		String value
		System.out.println("String Array");
		String s1[]=new String[4];
		s1[0]="Khan";
		s1[1]="Suraj";
		s1[2]="Dinga";
		
		for(int i=0;i<s1.length;i++) {
			System.out.println(s1[i]);
		}
		
		
	
//		Charecter Array
		System.out.println("Char array");
		char c1[]= new char[4];
		c1[0]='a';
		c1[1]='b';
		c1[2]=10;
		c1[3]=999;
		for(int i=0;i<c1.length;i++) {
			System.out.println(c1[i]);
		}
		
	}

}
