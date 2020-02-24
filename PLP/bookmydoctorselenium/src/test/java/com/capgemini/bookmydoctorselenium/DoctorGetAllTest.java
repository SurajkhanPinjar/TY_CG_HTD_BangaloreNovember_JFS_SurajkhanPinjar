package com.capgemini.bookmydoctorselenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoctorGetAllTest extends BaseTest{
	
	
	@Test
	public void testGetAllDoctor() {
		driver.get("localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
		
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[2]/a")).click();
		driver.close();
		
		
	}

}
