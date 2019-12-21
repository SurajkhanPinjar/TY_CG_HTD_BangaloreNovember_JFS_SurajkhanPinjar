package com.capgemini.springcores;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcores.beans.Animal;
import com.capgemini.springcores.beans.Pet;

public class XmlComponentScanTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");		//referring spring.xml
		
		Animal animal = context.getBean(Animal.class);
		animal.makeSound();
		
		Pet pet = context.getBean(Pet.class);
		pet.getAnimal().makeSound();
	}
}
