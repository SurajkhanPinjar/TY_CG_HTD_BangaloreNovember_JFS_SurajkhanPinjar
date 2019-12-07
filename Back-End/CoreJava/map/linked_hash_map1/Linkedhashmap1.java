package com.cap.Linkedhashmap1;

import java.util.*;

public class Linkedhashmap1 {
public static void main(String[] args) {
	LinkedHashMap<String,Integer> l=new LinkedHashMap<String,Integer>();
	l.put("BTM", 1234);
	l.put("Hebbal",234);
	l.put("byr", 1234);
	l.put(null, 456);
	//l.remove("BTM");
	Set<Map.Entry<String, Integer>> s=l.entrySet();
	for (Map.Entry<String, Integer> entry : s) {
		System.out.println(entry);
	}
	System.out.println(l.containsKey("BTM"));
	System.out.println(l.size());
	System.out.println(l.containsValue(1234));
	System.out.println(l.isEmpty());

	
}
}
