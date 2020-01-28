package com.capgemini.forestrymanagementselenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContracts extends BaseTest{

	@BeforeMethod
	public void loadDrive() {
		driver.get("http://localhost:4200");
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("admin");
		driver.findElement(By.id("adminPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testGetAllContracts() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[1]")).click();
		driver.findElement(By.id("contractNo")).sendKeys("115");
		driver.findElement(By.xpath("//*[@id=\"prodId\"]")).sendKeys("10");
		driver.findElement(By.id("customerId")).sendKeys("758");
		driver.findElement(By.id("quantity")).sendKeys("10");
		driver.findElement(By.xpath("/html/body/app-root/app-add-contracts/div/div/div[2]/form/button[1]")).click();
		driver.close();
		
	}
	
}
