package com.capgemini.thread.thread1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinputStream1 {
	public static void main(String[] args) {
		try {
			FileInputStream f1 =new FileInputStream("khan.txt");
//			System.out.println((char)a);
			int j=0;
			try {
				while((j=f1.read()) != -1) {
					System.out.print((char)j);
				}
			} catch (IOException e) {
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
