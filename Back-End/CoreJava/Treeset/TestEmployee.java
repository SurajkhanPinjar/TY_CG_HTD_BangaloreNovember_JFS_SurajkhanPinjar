import java.util.TreeSet;

public class TestEmployee 
{
public static void main(String[] args) {
	EmployeeAge e1=new EmployeeAge();
	TreeSet<Employee> t1=new TreeSet<Employee>(e1);
	t1.add(new Employee(24,33332,"Dilip"));
	t1.add(new Employee(22,33332,"Dilip"));
	t1.add(new Employee(29,33332,"Dilip"));
	t1.add(new Employee(11,33332,"Dilip"));
	t1.add(new Employee(11,333323,"Dilip"));
	//t1.remove(new Employee(11,333323,"Diliajk"));
	
	for (Employee e : t1) {
		System.out.println(e.name);
		System.out.println(e.sal);
		System.out.println(e.age);
	}
}
}
