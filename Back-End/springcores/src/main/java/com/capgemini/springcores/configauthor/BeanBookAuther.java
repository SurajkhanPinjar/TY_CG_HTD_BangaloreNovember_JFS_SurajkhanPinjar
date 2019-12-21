package com.capgemini.springcores.configauthor;

import org.springframework.context.annotation.Bean;

public class BeanBookAuther {
	
	
	@Bean("book")
	public Book getBook() {
		
		return new Book();
	}
	
	@Bean("author")
	public Author getAuthor() {
		return new Author();
	}
}
