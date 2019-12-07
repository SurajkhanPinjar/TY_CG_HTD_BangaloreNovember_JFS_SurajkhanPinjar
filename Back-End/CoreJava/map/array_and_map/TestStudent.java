package com.comb.arrayandmap;

import java.util.*;

public class TestStudent {
public static void main(String[] args) {
	ArrayList<Student> a=new ArrayList<Student>();
	a.add(new Student("Dilip"));
	a.add(new Student("pavan"));
	ArrayList<Student> a1=new ArrayList<Student>();
	a1.add(new Student("bha"));
	a1.add(new Student("hhhh"));
	ArrayList<Student> a2=new ArrayList<Student>();
	a2.add(new Student("jkjk"));
	a2.add(new Student("uhihi"));
	
	
	TreeMap<String,ArrayList<Student>> t=new TreeMap<String,ArrayList<Student>>();
	t.put("1st std",a);
	t.put("2nd std",a1);
	t.put("3rd std",a2);
	System.out.println(t.get("1st std"));
	
	
}
}
