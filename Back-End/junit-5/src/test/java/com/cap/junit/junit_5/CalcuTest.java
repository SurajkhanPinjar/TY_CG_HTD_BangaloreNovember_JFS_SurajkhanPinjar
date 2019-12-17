package com.cap.junit.junit_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcuTest {

	Calculator c=null;
			
	@BeforeEach
	void createObject() {
		c=new Calculator();
		
	}
	
	@Test
	void testAdd() {
		int i= c.add(20, 10);
		assertEquals(30, i);
		
	}
	
	@Test
	void testDiv() {

		assertThrows(ArithmeticException.class , () -> c.div(10, 0));
	}
	
	@Test
	void testArray() {
		assertThrows(ArrayIndexOutOfBoundsException.class, ( ) -> c.arrays(2)); 
	}
	

}
