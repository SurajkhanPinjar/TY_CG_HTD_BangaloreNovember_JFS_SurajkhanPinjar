package com.cap.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	public static void main(String[] args) {
		HashMap<Integer,String> h1=new HashMap<Integer,String>();
		h1.put(3, "Dilip");
		h1.put(4, "siva;");
		h1.put(1, "bharath");
		System.out.println(h1);
	
		Set<Map.Entry<Integer,String>> s1=h1.entrySet();
		for (Map.Entry<Integer ,String> e : s1) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			
		}
	}
}
