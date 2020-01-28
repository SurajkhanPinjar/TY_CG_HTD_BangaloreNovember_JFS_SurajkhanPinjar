package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScheduleContractsTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome  and enter Url for Schedule Contracts$")
	public void open_Chrome_and_enter_Url_for_Schedule_Contracts() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Login with Valid Scheduler Account to Schedule Contracts$")
	public void login_with_Valid_Scheduler_Account_to_Schedule_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("scheduler");
		driver.findElement(By.id("adminPassword")).sendKeys("Scheduler@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	
	}

	@Then("^Click On Contracts and select schedule Contracts$")
	public void click_On_Contracts_and_select_schedule_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-get-all-contracts-scheduler/div/table/tbody/tr[1]/td[7]/button")).click();
	}

	@Then("^Click on status field$")
	public void click_on_status_field() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"status\"]")).click();
	}

	@Then("^Select Status as Approved$")
	public void select_Status_as_Approved() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"status\"]/option[2]")).click();
	}

	@Then("^Logout the Scheduler Account$")
	public void logout_the_Scheduler_Account() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();      
	}

	@Then("^Login as Client Account with valid Credentils$")
	public void login_as_Client_Account_with_valid_Credentils() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	
	}

	@Then("^Click on Contracts and Choose All Contracts check for Status$")
	public void click_on_Contracts_and_Choose_All_Contracts_check_for_Status() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]")).click();
	}

	@Then("^Logout Client Account For Schedule Contracts$")
	public void logout_Client_Account_For_Schedule_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
	}

	@Then("^Close The Browser For Schedule Contracts$")
	public void close_The_Browser_For_Schedule_Contracts() throws Throwable {
		driver.close();
	}
	
}
