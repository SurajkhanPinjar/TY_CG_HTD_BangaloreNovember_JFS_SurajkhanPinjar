package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigationScheduler {
	
	WebDriver driver;
	
	@Given("^Open Browser and Enter Enter Valid URL for Navigation of Scheduler$")
	public void open_Browser_and_Enter_Enter_Valid_URL_for_Navigation_of_Scheduler() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@When("^Login with valid Scheduler Account for Navigation of Scheduler$")
	public void login_with_valid_Scheduler_Account_for_Navigation_of_Scheduler() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("scheduler");
		driver.findElement(By.id("adminPassword")).sendKeys("Scheduler@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	@Then("^Click on the Contracts Button in Scheduler Module and select schedule Contracts$")
	public void click_on_the_Contracts_Button_in_Scheduler_Module_and_select_schedule_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a")).click();
	}

	@Then("^Click on the Products Button in scheduler Module and click on all Products$")
	public void click_on_the_Products_Button_in_scheduler_Module_and_click_on_all_Products() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a")).click();
	}

	@Then("^Click On Logout Button for Scheduler Module$")
	public void click_On_Logout_Button_for_Scheduler_Module() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
	}

	@Then("^Close the Browser for Scheduler Module$")
	public void close_the_Browser_for_Scheduler_Module() throws Throwable {
		driver.close();
	}
	
}
