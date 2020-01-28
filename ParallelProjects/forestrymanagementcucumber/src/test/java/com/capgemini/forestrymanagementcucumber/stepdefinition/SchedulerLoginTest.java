package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SchedulerLoginTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome  and enter Url for Scheduler$")
	public void open_Chrome_and_enter_Url_for_Scheduler() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Enter valid Scheduler username and Password$")
	public void enter_valid_Scheduler_username_and_Password() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("scheduler");
		driver.findElement(By.id("adminPassword")).sendKeys("Scheduler@123");

	}

	@When("^Click on the Login Button Scheduler$")
	public void click_on_the_Login_Button_Scheduler() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();

	}

	@When("^Click The logout Button for Scheduler$")
	public void click_The_logout_Button_for_Scheduler() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		
	}

	@Then("^Close the driver for Scheduler$")
	public void close_the_driver_for_Scheduler() throws Throwable {
		driver.close();

	}
	
}
