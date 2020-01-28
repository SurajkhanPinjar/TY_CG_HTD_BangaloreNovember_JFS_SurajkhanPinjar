package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllContractsForClientTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome  and enter Url For get All Contracts for Client$")
	public void open_Chrome_and_enter_Url_For_get_All_Contracts_for_Client() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Login as  Client for get all Contracts for Client$")
	public void login_as_Admin_for_get_all_Contracts_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	}

	@Then("^click on Contracts in NavBar for Client$")
	public void click_on_Contracts_in_NavBar_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]")).click();
	}

	@Then("^Choose get all Contracts for Client$")
	public void choose_get_all_Contracts_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]")).click();
	}

	@Then("^logut and close the browser for get all Contracts for Client$")
	public void logut_and_close_the_browser_for_get_all_Contracts_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.close();
	}
	
}
