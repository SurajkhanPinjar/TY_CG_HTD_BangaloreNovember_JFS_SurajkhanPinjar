import java.util.ArrayList;
import java.util.List;

public class List1 {
	public static void main(String[] args) {
		List l1=new ArrayList();
		l1.add(0, 11);
		l1.add(1, 25);
		l1.add(2, 88);
		l1.add(3, 66);
		System.out.println(l1);
		
		l1.add(1,1000);
		System.out.println(l1);
		
		//Remmove
		l1.remove(2);
		System.out.println(l1);
		
		//Index Of
		System.out.println(l1.indexOf(11));
		
		//last index
		System.out.println(l1.lastIndexOf(66));
		
		System.out.println("---------index iterationss--------");
		
		for(int i=0;i<l1.size();i++) {
			System.out.println(l1.get(i));
		}
		
		System.out.println("--------------------------------------");
		
		List l2=new ArrayList();
		l2.add(10);
		l2.add(11);
		l2.add(13);
		l2.add(14);
		
		List l3=new ArrayList();
		l3.add(11);
		l3.add(14);
		l3.add(20);
		l3.add(25);
		
		System.out.println("l2 "+l2);
		System.out.println("l3 "+l3);
		
		l2.addAll(1,l3);
		System.out.println(l2);
		
		l2.set(0, 1000);
		System.out.println(l2);
		
		List l4=l3.subList(0,2);
		System.out.println(l4);
		
		
	}

}
