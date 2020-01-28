package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigationForAdminTest {
	
	WebDriver driver;
	
	@Given("^Open Browser and Enter Enter Valid URL for Navigation$")
	public void open_Browser_and_Enter_Enter_Valid_URL_for_Navigation() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Login with valid Admin Account for Navigation$")
	public void login_with_valid_Admin_Account_for_Navigation() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("admin");
		driver.findElement(By.id("adminPassword")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("^Click on Customer Button$")
	public void click_on_Customer_Button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a[2]")).click();
	}

	@Then("^Click on the Contracts Button$")
	public void click_on_the_Contracts_Button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[2]")).click();
	}

	@Then("^Click on the Products Button$")
	public void click_on_the_Products_Button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[2]")).click();
	}

	@Then("^Click on Land Button$")
	public void click_on_Land_Button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/div/a[2]")).click();
	}

	@Then("^Click on Accounts$")
	public void click_on_Accounts() throws Throwable {
	
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown4\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/div/a")).click();
	}

	@Then("^Click On Logout Button$")
	public void click_On_Logout_Button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
		driver.close();
	}
}
