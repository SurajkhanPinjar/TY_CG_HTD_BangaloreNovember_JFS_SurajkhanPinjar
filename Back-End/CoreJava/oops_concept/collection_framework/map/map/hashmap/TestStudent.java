package com.cap.map.hashmap;

import java.util.*;

public class TestStudent {
public static void main(String[] args) {
	HashMap<Integer,Student> h1=new HashMap();
	h1.put(10, new Student(22,"dilip"));
	h1.put(19, new Student(23,"dil"));
	h1.put(19, new Student(23,"diliiiiii"));
	h1.put(null, new Student(23,"dil"));
	Set<Integer>s1=h1.keySet();
	System.out.println(s1);
	Collection<Student> c1=h1.values();
	for (Student s : c1) {
		System.out.println(s);
	}
	
	System.out.println(h1.containsKey(10));
	System.out.println(h1.containsValue(new Student(23,"dil")));
	System.out.println(h1.size());
	System.out.println(h1.isEmpty());
	Set<Map.Entry<Integer,Student>> s2=h1.entrySet();
	for (Map.Entry<Integer ,Student> e : s2) {
		System.out.println(e.getKey());
		System.out.println(e.getValue());
	}
}
}
