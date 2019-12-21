package com.capgemini.springcores.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcores.beans.Cat;
import com.capgemini.springcores.beans.Dog;
import com.capgemini.springcores.beans.Hello;
import com.capgemini.springcores.beans.Pet;
import com.capgemini.springcores.configauthor.Author;
import com.capgemini.springcores.configauthor.Book;

@Configuration
public class BeansConfig {
	
	@Bean("hello")
//	@Scope("prototype")
	public Hello getHello() {   		//Factory Method
		Hello hello = new Hello();
		hello.setMessage("I love Marvel");
		hello.setCount(1000);
		return hello;

	}
	
	@Bean("dog")
	public Dog getDog() {
		return new Dog();
	}
	
	@Bean("cat")
	@Primary			//it Acts As Primary = true 
	public Cat getCat() {
		return new Cat();
	}
	
	
	// 1.Auto Wired
	@Bean("pet")
	public Pet getPet() {
		Pet pet = new Pet();
		pet.setName("Tuffy");
//		pet.setAnimal(getDog());
		return pet;
	}
	
	@Bean(name="book")
	public Book getBook() {
		Book book = new Book();
		book.setName("HarryP");
		book.setAuthor("khan");
		return book;
	}
	
	@Bean(name="author")
	public Author getAuthor() {
		Author author = new Author();
		author.setName("J.K.ROLLINGS");
		return author;
	}
	
}
