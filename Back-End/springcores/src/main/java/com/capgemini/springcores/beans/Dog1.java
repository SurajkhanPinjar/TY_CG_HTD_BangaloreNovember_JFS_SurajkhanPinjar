package com.capgemini.springcores.beans;

import org.springframework.stereotype.Component;

@Component			// Immediate creation of Object	
public class Dog1 implements Animal {
	
	
	@Override
	public void makeSound() {
		System.out.println("Boww Boww....!!!!!");
		
	}
}
