import java.util.Iterator;
import java.util.TreeSet;

public class TestStudent 
{
	public static void main(String[] args) {
		
	
TreeSet t= new TreeSet();
t.add(new Student(21,"Dilip"));
t.add(new Student(20,"dilip"));
Iterator itr=t.iterator();
while(itr.hasNext())
{
	System.out.println(itr.next());
}
}
}
