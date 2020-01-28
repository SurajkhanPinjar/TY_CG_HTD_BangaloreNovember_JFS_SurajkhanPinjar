package com.capgemini.forestrymanagementselenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomer extends BaseTest {
	
	@BeforeMethod
	public void loadDrive() {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("admin");
		driver.findElement(By.id("adminPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void testAdminLogin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a[1]")).click();
		driver.findElement(By.id("customerId")).sendKeys("147");
		driver.findElement(By.id("customerName")).sendKeys("saif");
		driver.findElement(By.id("streetAdd1")).sendKeys("Chikkodi");
		driver.findElement(By.id("streetAdd2")).sendKeys("Chikkodi Indira Nagar");
		driver.findElement(By.id("town")).sendKeys("chikkodi");
		driver.findElement(By.id("email")).sendKeys("khansuraj@g.com");
		driver.findElement(By.id("postalCode")).sendKeys("591222");
		driver.findElement(By.id("telephone")).sendKeys("9632448701");
		driver.findElement(By.xpath("//*[@id=\"addCustomerButton\"]")).click();
		driver.close();
		
		
	}

}











