package com.capgemini.bookmydoctorselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUpdateDoctorProfile extends BaseTest{
	
	
	@Test
	public void testTestUpdateDoctor() {
		
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("doctor@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("Doctor@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();driver.findElement(By.xpath("/html/body/app-root/app-header/nav[2]")).click();
        driver.findElement(By.xpath("/html/body/app-root/app-doctor-nav/div")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-doctor-nav/div/a[1]")).click();

		driver.findElement(By.id("firstName")).sendKeys("Sahana");
		driver.findElement(By.id("lastName")).sendKeys("Kamath");
		driver.findElement(By.xpath("//*[@id=\"myList\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"myList\"]/option[1]")).click();	
		driver.findElement(By.id("clinicName")).sendKeys("Wales");
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[2]/a")).click();
		driver.close();
		
	}

}
