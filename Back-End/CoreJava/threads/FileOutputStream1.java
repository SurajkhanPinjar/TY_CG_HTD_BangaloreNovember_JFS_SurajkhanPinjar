package com.capgemini.thread.thread1;

import java.io.FileOutputStream;

public class FileOutputStream1 {
	public static void main(String[] args) {
		try {
			FileOutputStream f1=new FileOutputStream("khan.txt");
			String s1="khannnn";
			byte[] b1=s1.getBytes();
			f1.write(b1);
			System.out.println("Success.......");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
