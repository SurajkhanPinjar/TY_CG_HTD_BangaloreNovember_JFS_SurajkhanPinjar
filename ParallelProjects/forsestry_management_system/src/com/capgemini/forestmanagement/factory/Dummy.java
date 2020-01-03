package com.capgemini.forestmanagement.factory;

public class Dummy {
	public static void main(String[] args) {
		
		String s = "591222";
		System.err.println(Validation.isValidTel(s)); 
		System.out.println();
		
		System.out.println(s.length() == 6);
	}
}
