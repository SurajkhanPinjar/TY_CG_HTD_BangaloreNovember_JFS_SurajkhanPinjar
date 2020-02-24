package com.capgemini.bookmydoctorselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PatientLoginTest extends BaseTest{
	
	
	@Test
	public void testPatientLogin() {
		
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("patient@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("Patient@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
			
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[2]/a")).click();
		driver.close();
	}

}
