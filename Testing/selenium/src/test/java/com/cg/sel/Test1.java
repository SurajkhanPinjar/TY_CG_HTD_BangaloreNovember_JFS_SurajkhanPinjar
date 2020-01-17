package com.cg.sel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class Test1 {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com");
		Reporter.log("from testannot demo2", true);
	}

}
