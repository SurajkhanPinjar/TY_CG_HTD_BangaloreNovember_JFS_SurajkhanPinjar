import java.util.ArrayList;
import java.util.Collection;

public class Collection3 {
	public static void main(String[] args) {
		Collection c1= new ArrayList();
		c1.add(10);
		c1.add(25);
		c1.add(36);
		System.out.println("c1 "+ c1);
		
		Collection c2=new ArrayList();
		c2.add(25);
		c2.add(33);
		System.out.println("c2: "+c2);
		
		c1.addAll(c2);
		System.out.println("c1 adda all: "+c1);
		
		c1.removeAll(c2);
		System.out.println(c1);
		
		
		c1.retainAll(c2);
		System.out.println(c1);
		
		Collection c3=new ArrayList<>();
		c3.add(11);
		c3.add(32);
		
		Collection c4=new ArrayList<>();
		c4.add(11);
		c4.add(35);
		c4.add(32);
		c4.add(45);
		
		c3.retainAll(c4);
		System.out.println(c3);
		
		
		System.out.println(c3.containsAll(c4));
		
		
		c4.clear();
		System.out.println(c4);
		
		Collection c5=new ArrayList();
		c5.add(25);
		c5.add(65);
		
		
//		Collection to array
		Object a[] =c5.toArray();
		for (int i=0;i<a.length;i++) {
			
			System.out.println("a["+i+"] ="+a[i]);
		}
		
		
		
		
	}

}
