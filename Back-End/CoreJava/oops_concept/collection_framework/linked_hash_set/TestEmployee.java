import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestEmployee 
{
	public static void main(String[] args) {
		
	
LinkedHashSet<Employee> l=new LinkedHashSet<Employee>();
l.add(new Employee(10,"Dilip"));
l.add(new Employee(10,"Dilip"));
Iterator itr=l.iterator();
while(itr.hasNext())
{
	System.out.println(itr.next());
}
}
}
