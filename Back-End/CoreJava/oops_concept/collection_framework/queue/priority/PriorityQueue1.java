package com.cap.Queue.priority;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 
{
public static void main(String[] args) {
	Queue q=new PriorityQueue();
	q.offer(10);
	q.offer(9);
	q.offer(2);
	q.offer(9);
	q.offer(2);

	 
	System.out.println(q);
	q.remove();
	System.out.println(q);
	q.add(1);
	System.out.println(q);
	q.poll();
 
	System.out.println(q);
	System.out.println(q.element());
	System.out.println(q.peek());
}
}
