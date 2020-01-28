package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllProductsForAdminTest {
	
	WebDriver driver;
	
	@Given("^Open Chrome and enter Url For get all Product details$")
	public void open_Chrome_and_enter_Url_For_get_all_Product_details() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	}

	@When("^Login as  Admin for get all Product details$")
	public void login_as_Admin_for_get_all_Product_details() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("admin");
		driver.findElement(By.id("adminPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("^Click on Products in NavBar$")
	public void click_on_Products_in_NavBar() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]")).click();
	}

	@Then("^Choose Get All Product$")
	public void choose_Get_All_Product() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[2]")).click();
	}
	

	@Then("^Logout and close the browser for get all Product details$")
	public void logout_and_close_the_browser_for_get_all_Product_details() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
		driver.close();
	}
}
