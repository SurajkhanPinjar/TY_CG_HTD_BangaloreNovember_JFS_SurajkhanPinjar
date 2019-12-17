package com.cap.junit.junit_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalculator {
	
	Calculator c= null;
	
	@BeforeEach
	void createObject() {
		c=new Calculator();
	}

@Test
   public void test() {
		Calculator c= new Calculator();
		int i=c.add(10, 20);
		assertEquals(30, i);
	}

@Test
	public void testForNeg() {
	Calculator c1=new Calculator();
	int i=c1.add(-10, 20);
	assertEquals(10, i);
}

@Test
public void testForMul() {
	Calculator c1=new Calculator();
	int i=c1.mul(10, 20);
	assertEquals(200, i);
	int i1=c1.div(20, 10);
	assertEquals(2, i1);
}

@Test
public void testFordiv() {
	Calculator c1=new Calculator();
	int i=c1.div(20, 20);
	assertEquals(1, i);
}

@Test
public void testFordiv1() {
	Calculator c1=new Calculator();

}

@Test
public void testForLength() {
	Calculator c=new Calculator();
	int i= c.findLength("khan");
	assertEquals(4, i);
}

@Test
public void testForLength1() {
	Calculator c=new Calculator();
	
	assertThrows(NullPointerException.class,() -> c.findLength(null));
}
}
