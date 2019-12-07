package com.capgemini.thread.thread1;

public class TestA {
	public static void main(String[] args) {
		System.out.println("Main Starts...");
		Thread1 t1=new Thread1();
		t1.start();
		System.out.println("Main Ends.....");
	}

}
