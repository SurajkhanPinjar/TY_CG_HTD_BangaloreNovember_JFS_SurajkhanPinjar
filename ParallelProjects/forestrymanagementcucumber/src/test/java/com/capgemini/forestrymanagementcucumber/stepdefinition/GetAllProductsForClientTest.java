package com.capgemini.forestrymanagementcucumber.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllProductsForClientTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome and enter Url For get all Product details for Client$")
	public void open_Chrome_and_enter_Url_For_get_all_Product_details_for_Client() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	}

	@When("^Login as  Client for get all Product details for Client$")
	public void login_as_Admin_for_get_all_Product_details_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	}

	@Then("^Click on Products in NavBar for Client$")
	public void click_on_Products_in_NavBar_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
	}

	@Then("^Choose Get All Product for Client$")
	public void choose_Get_All_Product_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a")).click();
	}

	@Then("^Logout and close the browser for get all Product details for Client$")
	public void logout_and_close_the_browser_for_get_all_Product_details_for_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.close();
	}
	
}
