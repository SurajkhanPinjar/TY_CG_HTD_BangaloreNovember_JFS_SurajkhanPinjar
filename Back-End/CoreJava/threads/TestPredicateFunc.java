package com.capgemini.thread.thread1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestPredicateFunc {
	public static void main(String[] args) {
		System.out.println("-----------Predicate-------");
		Predicate<Integer> p = i-> i%2 == 0;
		
		boolean b1=p.test(12);
		System.out.println(b1);
		System.out.println(p.test(557));
		
		System.out.println("------------Function-------");
		Function<Integer, Integer> f = i -> i*100;
		int i1 = f.apply(50);
		System.out.println(i1);
		
		System.out.println("--------------Supplier--------");
		Supplier<Person> s1 = ( ) -> new Person(22, "Khan");
		System.out.println(s1.get().getAge());
		System.out.println(s1.get().getName());
		
		System.out.println("----------Consumer------------");
		Consumer<Person> c1 = j -> {
			System.out.println(j.getAge());
			System.out.println(j.getName());
		
		};
		Person p1 = new Person(23, "Khan");
			c1.accept(p1);
	}

}
