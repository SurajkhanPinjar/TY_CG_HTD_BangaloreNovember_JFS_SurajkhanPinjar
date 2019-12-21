package com.capgemini.springcores;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcores.beans.Animal;
import com.capgemini.springcores.beans.Hello;
import com.capgemini.springcores.beans.Pet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	Hello hello1 = context.getBean(Hello.class);
    	System.out.println(hello1.getMessage());
    	System.out.println(hello1.getCount());
    	System.out.println("****************");
    	System.out.println("****************");
    	Hello hello2 = context.getBean(Hello.class);
    	System.out.println(hello1 ==hello2); 
    	
    	System.out.println(hello1);
    	System.out.println(hello2);
    	
    	System.out.println("****************");
    	Animal animal = context.getBean(Animal.class);
    	animal.makeSound();
    	System.out.println("**********");
    	Pet pet = context.getBean(Pet.class);
    	System.out.println(pet.getName());
    	pet.getAnimal().makeSound();
    }
}
