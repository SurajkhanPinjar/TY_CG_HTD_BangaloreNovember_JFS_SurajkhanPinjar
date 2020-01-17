package com.cg.assertion;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionValidation {
	
	@Test
	public void test1() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		String actual = driver.getTitle();
		String expected = "actiTIME - Login";
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
//	@Test
//	public void test2() {
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("https://demo.actitime.com/login.do");
//		String actual = driver.getTitle();
//		String expected = "actiTIME";
//		SoftAssert s = new SoftAssert();
//		s.assertEquals(actual, expected);
//		driver.close();
//		s.assertAll();
//		
//		
//		
//	}

}
