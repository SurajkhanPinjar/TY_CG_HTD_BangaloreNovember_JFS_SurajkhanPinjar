package com.capgemini.springcores.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Pet {
	private String name;
	@Autowired
	//@Qualifier("dog") //Treated as Auto wired ByName		// it should not present for @componentsss
	private Animal animal ;
	
	public Pet() {		//Constructor
		
	}
	
	public Pet(String name, Animal animal) {
		this.name = name;
		this.animal = animal;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
