package com.capgemini.springcores.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcores.beans.Animal;
import com.capgemini.springcores.beans.Hello;
import com.capgemini.springcores.beans.Pet;

public class AnnotationConfigApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		Hello hello1 = context.getBean(Hello.class);
		Hello hello2 = context.getBean(Hello.class);
		System.out.println(hello1.getMessage());
		System.out.println(hello1.getCount());
		System.out.println("&***************");
		System.out.println(hello2.getMessage());
		System.out.println(hello2.getCount());
		System.out.println(hello1==hello2);
		
		System.out.println("************");
		Animal animal = context.getBean(Animal.class);
		animal.makeSound();
		
		
		System.out.println("****************");
		Pet pet = context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		context.close();
		
		
	}
}
