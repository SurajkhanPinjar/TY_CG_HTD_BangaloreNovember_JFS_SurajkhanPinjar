package com.capgemini.forestrymanagementselenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SchedulerContracts extends BaseTest {
	
	@BeforeMethod
	public void loadDrive() {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("scheduler");
		driver.findElement(By.id("adminPassword")).sendKeys("Scheduler@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testGetAllContracts() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-get-all-contracts-scheduler/div/table/tbody/tr[1]/td[7]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"deliveryDate\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"status\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"status\"]/option[2]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-schedule-contracts/div/div/div[2]/form/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.close();
	}
	
	
	
	
	

}
