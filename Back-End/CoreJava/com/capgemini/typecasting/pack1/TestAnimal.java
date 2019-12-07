package com.capgemini.typecasting.pack1;

public class TestAnimal {
	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.eat();
		
		Animal a2=new Dog();
		a2.eat();
		Dog d1=(Dog)a2;
		d1.eat();
		d1.walk();
		
		Animal a3=new Cat();
		a3.eat();
		
		Cat c1=(Cat)a3;
		c1.eat();
		c1.run();
		
		
	}

}
