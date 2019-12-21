package com.capgemini.springcores.configauthor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcores.config.BeansConfig;

public class AnnotationBookAuthor {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		
		Author a = context.getBean(Author.class);
		Book b = context.getBean(Book.class);
		System.out.println("Book is "+ b.getName());
		System.out.println("Author "+ a.getName());
		
	}

}
