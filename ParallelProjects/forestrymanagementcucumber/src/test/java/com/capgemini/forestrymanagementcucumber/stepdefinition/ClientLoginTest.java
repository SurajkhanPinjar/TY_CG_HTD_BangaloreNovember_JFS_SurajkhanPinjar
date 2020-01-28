package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClientLoginTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome  and enter Url for Client$")
	public void open_Chrome_and_enter_Url_for_Client() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Enter valid Client username and Password$")
	public void enter_valid_Client_username_and_Password() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");

	}

	@When("^Click on the Login Button Client$")
	public void click_on_the_Login_Button_Client() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();

	}

	@When("^Click The logout Button for Client$")
	public void click_The_logout_Button_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		
	}

	@Then("^Close the driver for Client$")
	public void close_the_driver_for_Client() throws Throwable {
		driver.close();

	}

}
