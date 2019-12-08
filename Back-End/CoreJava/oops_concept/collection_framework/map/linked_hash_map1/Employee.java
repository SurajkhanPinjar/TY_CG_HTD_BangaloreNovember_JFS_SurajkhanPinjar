package com.cap.Linkedhashmap1;

public class Employee {
int sal;
String emp;
/**
 * @param sal
 * @param emp
 */
public Employee(int sal, String emp) {
	super();
	this.sal = sal;
	this.emp = emp;
}
@Override
public String toString() {
	return "Employee [sal=" + sal + ", emp=" + emp + "]";
}

}
