import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedL1 {
	public static void main(String[] args) {
		LinkedList l1=new LinkedList();
		l1.add(2);
		l1.add(22);
		l1.add(36);
		l1.add(55);
		l1.add(2);
		l1.add(null);
		System.out.println(l1);
		System.out.println("-------Iterator------");
		ListIterator itr =l1.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("-------For Each-----------");
		for (Object i1 : l1) {
			System.out.println(i1);
			
		}
		
		System.out.println("----------For Loop---------");
		for(int i=0;i<l1.size();i++) {
			System.out.println(l1.get(i));
		}
		
		
		l1.remove(new Integer(2));
		System.out.println(l1);
		
	}

}
