package com.cap.Treemap;

import java.util.Comparator;

public class MyComparator implements Comparator{

	

	@Override
	public int compare(Object o1, Object o2) {
		Integer i1=(Integer)o1;
		Integer i2=(Integer)o2;
		return (i2-i1);
	}

//	@Override
//	public int compare(TreeMap1 o1, TreeMap1 o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
