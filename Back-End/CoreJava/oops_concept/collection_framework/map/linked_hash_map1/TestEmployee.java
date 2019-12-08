package com.cap.Linkedhashmap1;

import java.util.*;
import java.util.Map.Entry;

public class TestEmployee {
public static void main(String[] args) {
	LinkedHashMap<Integer,Employee> l=new LinkedHashMap<Integer,Employee>();
	l.put(10,new Employee(234,"boy"));
	l.put(13,new Employee(2006,"Ramesh"));
	l.put(11,new Employee(2033,"Ramesh"));
	l.put(14, new Employee(234,"boy"));
	//System.out.println(l);
	Collection<Employee> c=l.values();
	System.out.println(c);
	Set<Entry<Integer, Employee>> s=l.entrySet();
	for (Entry<Integer, Employee> entry : s) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
	System.out.println(l.get(10));
}
}
