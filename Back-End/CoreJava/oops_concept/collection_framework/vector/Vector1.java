import java.util.Vector;

public class Vector1 {
	public static void main(String[] args) {
		Vector v1=new Vector();
		v1.add(10);
		v1.add(22);
		v1.add(35);
		v1.add(60);
		System.out.println(v1);
		
		System.out.println("--------remove--------");
		v1.remove(new Integer(10));
		System.out.println(v1);
		
		System.out.println("---------set-----------");
		v1.set(1, 100);
		System.out.println(v1);
		
		System.out.println("-----------for Iter-----");
		for(int i=0;i<v1.size();i++)
		{
			System.out.println(v1.get(i));
		}
 	}

}
