package com.cap.Queue.priority;

import java.util.PriorityQueue;

public class TestStudent1 
{
	public static void main(String[] args) {
		
	
PriorityQueue<Student> p1=new PriorityQueue();
p1.offer(new Student(22,"dilip"));
p1.offer(new Student(21,"dilip"));
for (Student student : p1) {
	System.out.println(student.age);
}
}
}
