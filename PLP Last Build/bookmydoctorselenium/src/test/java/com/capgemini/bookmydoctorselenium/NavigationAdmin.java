package com.capgemini.bookmydoctorselenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class NavigationAdmin extends BaseTest {

	@Test
	public void testNavigatingAdmin() {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
		
		//Navigation
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[3]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[4]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[5]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[6]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[7]")).click();
		
		//Logout
		driver.findElement(By.xpath("//*[@id=\"navbarNav \"]/ul/li[2]/a")).click();
		driver.close();
		
	}
}
