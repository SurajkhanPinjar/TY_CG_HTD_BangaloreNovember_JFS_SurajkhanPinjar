package com.cap.Treemap;

public class Student  {
int age;
String name;
/**
 * @param age
 * @param name
 */
public Student(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}
//@Override
//public int compareTo(Student o) {
//	return (o.age-this.age);
//}
@Override
public String toString() {
	return "Student [age=" + age + ", name=" + name + "]";
}


}
