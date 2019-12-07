import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListString {
	public static void main(String[] args) {
	ArrayList<String> a1=new ArrayList<String>();
	a1.add("Kinga");
	a1.add("Dinga");
	a1.add("Dingi");
	a1.add("Manga");
	System.out.println("a1 "+a1);
	System.out.println(a1.size());
	System.out.println(a1.isEmpty());
	
	ArrayList<String> a2=new ArrayList<String>();
	a2.add("Tanga");
	a2.add("Dinga");
	a2.add("Dingi");
	a2.add("Janga");
	System.out.println("a2 "+a2);
	System.out.println(a1.contains(a2));
	a1.add("Khan");
	System.out.println(a1);
	
	a1.addAll(a2);
	System.out.println(a1);

	a1.removeAll(a2);
	
	
	ArrayList<String> a3=new ArrayList<String>();
	a3.add("Tanga");
	a3.add("Dinga");
	a3.add("Dingi");
	a3.add("Janga");
	
	ArrayList<String> a4=new ArrayList<String>();
	a4.add("Tanga");
	a4.add("Dinga");
	a4.add("Ding");
	a4.add("Jang");
	System.out.println(" ");
	a3.retainAll(a4);
	System.out.println(a3);
	
	System.out.println("--------list of link-------");
	ArrayList<String> a7=new ArrayList<String>();
	a7.add("Tanga");
	a7.add("Dinga");
	a7.add("Ding");
	a7.add("Jang");
	a7.add("John");
	System.out.println(a7.indexOf("Dinga"));
	
	System.out.println("------Last ind----");
	System.out.println(a7.lastIndexOf("John"));

	System.out.println("------get----");
	System.out.println(a7.get(0));
	
	System.out.println("---------add all------");
	a7.addAll(a4);
	System.out.println(a7);
	
	System.out.println("-----SubList-----");
	List a8=a7.subList(0, 4);
	System.out.println(a8);
	
	
	
	
	
	a4.remove(new String("Tanga"));
	System.out.println(a4);
	
	System.out.println("------For-------");
	for(int i=0;i<a3.size();i++) {
		System.out.println(a1.get(i));
	}
	
	System.out.println("------ForHeap------");
	for (String str : a4) {
		System.out.println(str);
		
		
	}
	System.out.println("-------List Forward-------");
	ListIterator<String > str1=a4.listIterator();
	while(str1.hasNext()) {
		System.out.println(str1.next());
	}
	System.out.println("-------List Previous-------");
	while(str1.hasPrevious()) {
		System.out.println(str1.previous());
	}
	
	
	
}
}
