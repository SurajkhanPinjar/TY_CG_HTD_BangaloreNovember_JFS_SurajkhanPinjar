package com.capgemini.forestrymanagementcucumber.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	WebDriver driver ;
	
	@Given("^Open Chrome  and Start Application$")
	public void open_Chrome_and_Start_Application() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
	
	}

	@When("^I enter valid username and Password$")
	public void i_enter_valid_username_and_Password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("surajkhanpinjar@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("suraj@123");
	}

	@Then("^Login should be Successful$")
	public void login_should_be_Successful() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
		}
	
	
}
