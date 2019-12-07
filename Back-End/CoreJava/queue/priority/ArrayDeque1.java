package com.cap.Queue.priority;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayDeque1 
{
	public static void main(String[] args) {
		
	
	Queue a1=new ArrayDeque();
	
	a1.add("Hello");
	a1.add("bye");
	a1.add("Hello");
	a1.offer("seri");
	a1.offer(10);
	a1.offer(10);
	
	
	
	System.out.println(a1);
	a1.remove();
	System.out.println(a1);
	a1.peek();
	System.out.println(a1.peek());
	
}
}
