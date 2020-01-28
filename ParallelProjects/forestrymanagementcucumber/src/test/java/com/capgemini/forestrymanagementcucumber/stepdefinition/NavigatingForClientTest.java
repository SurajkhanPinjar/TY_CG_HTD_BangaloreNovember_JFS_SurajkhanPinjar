package com.capgemini.forestrymanagementcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigatingForClientTest {
	
	WebDriver driver;
	
	@Given("^Open Browser and Enter Enter Valid URL for Navigation of Client$")
	public void open_Browser_and_Enter_Enter_Valid_URL_for_Navigation_of_Client() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Login with valid Client Account for Navigation of Client$")
	public void login_with_valid_Client_Account_for_Navigation_of_Client() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[1]/a")).click();
		driver.findElement(By.id("adminName")).sendKeys("client");
		driver.findElement(By.id("adminPassword")).sendKeys("Client@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[3]/button")).click();
	
	}

	@Then("^Click on Customer Button in Client Module and select add Customer$")
	public void click_on_Customer_Button_in_Client_Module_and_select_add_Customer() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/a[1]")).click();
	}

	@Then("^Click on the Contracts Button in Client Module and select add Contracts$")
	public void click_on_the_Contracts_Button_in_Client_Module_and_select_add_Contracts() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[1]")).click();
	}

	@Then("^Click on the Products Button in Client Module and click on all Products$")
	public void click_on_the_Products_Button_in_Client_Module_and_click_on_all_Products() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a")).click();
	}

	@Then("^Click On Logout Button for Client Module$")
	public void click_On_Logout_Button_for_Client_Module() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/ul/li[3]/a")).click();
	}

	@Then("^Close the Browser for Client Module$")
	public void close_the_Browser_for_Client_Module() throws Throwable {
		driver.close();
	}
	
}
