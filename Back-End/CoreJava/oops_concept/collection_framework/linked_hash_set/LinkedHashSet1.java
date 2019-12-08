import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet1 
{
public static void main(String[] args) {
	LinkedHashSet l=new LinkedHashSet();
	l.add(10);
	l.add(20);
	l.add(10);
	l.add(null);
	l.add("kkkk");
	Iterator itr=l.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}


//LinkedHashSet<Integer> l=new LinkedHashSet<Integer>();
//l.add(10);
//l.add(20);
//l.add(10);
//l.add(null);
//Iterator itr=l.iterator();
//while(itr.hasNext())
//{
//	System.out.println(itr.next());
//}
}
}



