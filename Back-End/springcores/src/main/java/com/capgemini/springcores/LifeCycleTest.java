package com.capgemini.springcores;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcores.beans.Hello;

public class LifeCycleTest {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Hello hello = context.getBean(Hello.class);
		
		System.out.println(hello.getMessage());
		System.out.println(hello.getCount());
		
		context.close();  //close() method is not present in ApplicationContext in interface henc we taking a class in CPXAC
	}

}
