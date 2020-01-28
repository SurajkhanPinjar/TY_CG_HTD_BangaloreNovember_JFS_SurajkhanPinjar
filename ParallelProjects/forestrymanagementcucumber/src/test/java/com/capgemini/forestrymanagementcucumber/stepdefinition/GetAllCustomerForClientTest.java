package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllCustomerForClientTest {
 
	WebDriver driver;
	
	@Given("^Open Chrome  and enter Url For get All Customer For Client$")
	public void open_Chrome_and_enter_Url_For_get_All_Customer_For_Client() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User is login As Client$")
	public void user_is_login_As_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	
	}

	@Then("^click on Customer in NavBar For Client$")
	public void click_on_Customer_in_NavBar_For_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();
	}

	@Then("^Choose get all customer For Client$")
	public void choose_get_all_customer_For_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a[2]")).click();
	}

	@Then("^logut and close the browser For Client$")
	public void logut_and_close_the_browser_For_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.close();
	}

}
