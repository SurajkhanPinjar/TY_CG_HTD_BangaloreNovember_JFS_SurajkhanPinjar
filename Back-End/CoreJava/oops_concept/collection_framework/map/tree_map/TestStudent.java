package com.cap.Treemap;

import java.util.*;
import java.util.Map.Entry;

public class TestStudent {
public static void main(String[] args) {
	StudentAge a=new StudentAge();
	TreeMap<Student,String> t=new TreeMap<Student,String>(a);
	
	t.put(new Student(23,"Dilip"), "1st std");
	t.put(new Student(20,"siva"), "2nd std");
	t.put(new Student(19,"bharath"), "3rd std");
	Set<Entry<Student, String>> s=t.entrySet();
	for (Entry<Student, String> e : s) {
		System.out.println(e.getKey());
		System.out.println(e.getValue());
	}
}
}
