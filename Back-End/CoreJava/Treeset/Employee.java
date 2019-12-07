
public class Employee 
{
int age;
double sal;
String name;
/**
 * @param age
 * @param sal
 * @param name
 */
public Employee(int age, double sal, String name) {
	super();
	this.age = age;
	this.sal = sal;
	this.name = name;
}
//@Override
//public int compareTo(Employee o) {
//	if(this.sal>o.sal)
//	{
//		return 1;
//	}
//	 if(this.sal<o.sal)
//	{
//		return -1;
//	}
//	else
//		return 0;
//}
//@Override
//public int compareTo(Employee o) {
//	return this.name.compareTo(o.name);
//	}
//@Override
//public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//	result = prime * result + age;
//	result = prime * result + ((name == null) ? 0 : name.hashCode());
//	long temp;
//	temp = Double.doubleToLongBits(sal);
//	result = prime * result + (int) (temp ^ (temp >>> 32));
//	return result;
//}
//@Override
//public boolean equals(Object obj) {
//	if (this == obj)
//		return true;
//	if (obj == null)
//		return false;
//	if (getClass() != obj.getClass())
//		return false;
//	Employee other = (Employee) obj;
//	if (age != other.age)
//		return false;
//	if (name == null) {
//		if (other.name != null)
//			return false;
//	} else if (!name.equals(other.name))
//		return false;
//	if (Double.doubleToLongBits(sal) != Double.doubleToLongBits(other.sal))
//		return false;
//	return true;
//}


}
