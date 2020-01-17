package com.cg.sel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test2 {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com");
		Reporter.log("from testannot demo2", true);
	}
	
	@Test
	public void test1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Reporter.log("from testannot demo2", true);
	}
	
	@Test
	public void test3() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com");
		Reporter.log("from testannot demo2", true);
	}
}
