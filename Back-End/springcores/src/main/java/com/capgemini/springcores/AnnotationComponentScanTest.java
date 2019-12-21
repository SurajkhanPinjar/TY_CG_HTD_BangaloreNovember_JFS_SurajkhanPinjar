package com.capgemini.springcores;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcores.beans.Animal;
import com.capgemini.springcores.beans.Pet;
import com.capgemini.springcores.config.ComponentScanConfig;

public class AnnotationComponentScanTest {

		public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
			
			Animal animal = context.getBean(Animal.class);
			animal.makeSound();
			
			Pet pet = context.getBean(Pet.class);
			pet.getAnimal().makeSound();
		}
}
