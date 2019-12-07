package com.capgemini.thread.thread1;

public class Thread2 implements Runnable {
	@Override
	public void run() {

		for(int i=0;i<4;i++) {
			System.out.println(i);
		}
	}

}
