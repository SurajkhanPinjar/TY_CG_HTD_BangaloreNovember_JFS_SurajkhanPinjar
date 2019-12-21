package com.capgemini.springcores.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello /* implements InitializingBean, DisposableBean */{
	private String message;
	private int count;

	public Hello() {
		System.out.println("Class Loaded");
	}

	public Hello(String message, int count) {
		this.message = message;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	 Methods 
	//
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}

	@PreDestroy
	  public void destroy( ) 
	  { System.out.println("Destroy Method"); 
	}
	 

//	@Override
//	public void afterPropertiesSet() throws Exception { // this is for inititalization Field
//		// TODO Auto-generated method stub
//
//	}



}
