package com.capgemini.forestmanagement.main;

import java.util.Scanner;

import com.capgemini.forestmanagement.bean.ClientBean;
import com.capgemini.forestmanagement.dao.ClientDao;
import com.capgemini.forestmanagement.factory.Factory;
import com.capgemini.forestmanagement.factory.Validation;

public class ClientMain {
	
	public static ClientDao clientDao = Factory.clientIml();
	
	public static void clientMain() {
		Scanner sc = new Scanner(System.in);
		
		char c1 = 'a';
		while(c1 =='a') {
			
		int c=0;
		char chh1 = 'y';
		while( chh1 == 'y') {
		System.out.println("Enter 1 : Login \nEnter 2 : Back \nEnter 3 : Home \n");
		String v1 = sc.next();
		if (Validation.isNumber1(v1)) {
			c = Integer.parseInt(v1);
			chh1 ='n';
		}else {
			System.err.println("Enter only integers:");
		}
		}
		
		switch (c) {
		case 1:
			ClientSection.loginClient();
			break;
		case 2	:
			c1 = 'b';
			return;
		
		
		case 3: 
			MainHome.mainHome();
			
		default:
			System.err.println("Invalid Choice :(");
			break;
		}
	}

}
}

