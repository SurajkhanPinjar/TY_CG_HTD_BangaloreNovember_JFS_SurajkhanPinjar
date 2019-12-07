package com.capgemini.thread.thread1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(24);
		a1.add(25);
		a1.add(74);
		a1.add(55);
		a1.add(66);
		a1.add(87);
	
		List<Integer> l1 = a1.stream().filter(i -> i % 2 == 0 ).collect(Collectors.toList());
		System.out.println("even No.s are " +l1);
		
		List<Integer > l2 = a1.stream().map(i -> i * 100).collect(Collectors.toList());
		System.out.println(l2);
		
		Optional<Integer> o1= a1.stream().max((i,j)->i.compareTo(j));
		System.out.println(o1);
		
		System.out.println(a1.str6eam().count());
	}

}
