import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
public static void main(String[] args) {
	Collection c1=new ArrayList();
	
	c1.add(12);
	System.out.println(c1);
	
	c1.remove(12);
	System.out.println(c1);
	
	System.out.println(c1.isEmpty());
	
	System.out.println(c1.contains(12));
	
	c1.add("Khan");
	System.out.println(c1);
	
	c1.add(null);
	c1.add(0.00009);
	System.out.println(c1);
	
	
	
}
}
