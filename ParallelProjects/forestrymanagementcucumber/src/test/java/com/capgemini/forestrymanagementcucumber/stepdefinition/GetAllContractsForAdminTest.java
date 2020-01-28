package com.capgemini.forestrymanagementcucumber.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllContractsForAdminTest {
	
	WebDriver driver;
	
	
	@Given("^Open Chrome  and enter Url For get All Contracts$")
	public void open_Chrome_and_enter_Url_For_get_All_Contracts() throws Throwable {
		driver =  new ChromeDriver();
		driver.get("http://localhost:4200");
	
	}

	@When("^Login as  Admin for get all Contracts$")
	public void login_as_Admin_for_get_all_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("admin");
		driver.findElement(By.id("adminPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	}

	@Then("^click on Contracts in NavBar$")
	public void click_on_Contracts_in_NavBar() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();

	}

	@Then("^Choose get all Contracts$")
	public void choose_get_all_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]")).click();

	}

	@Then("^logut and close the browser for get all Contracts$")
	public void logut_and_close_the_browser_for_get_all_Contracts() throws Throwable {
		driver.close();
	
	
	}
	
	
}
