package com.capgemini.forestrymanagementselenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginCredentials extends BaseTest{
	
	@BeforeMethod
	public void loadDrive() {
		driver.get("http://localhost:4200");
		
	}
	
	@Test
	public void testAdminLogin() {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("admin");
		driver.findElement(By.id("adminPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testClientLogin() {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSchedulerLogin() {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("scheduler");
		driver.findElement(By.id("adminPassword")).sendKeys("Scheduler@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
	}
	
	
	
	


	
}
