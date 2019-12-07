package com.cap.Treemap;

import java.util.*;

public class TreeMap1  {
public static void main(String[] args) {
	Map<Integer,String> t=new TreeMap<Integer,String>(new MyComparator());
	t.put(10, "dILIP");
	t.put(11, "siva");
	t.put(12, "siva");
	t.put(45, null);
	System.out.println(t);
	
}


}
