package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminLogin {
	WebDriver driver;

	@Given("^Open Chrome Browser and Enter The Url for Admin Login$")
	public void open_Chrome_Browser_and_Enter_The_Url_for_Admin_Login() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
		
	}

	@When("^Enter the Admin Email Id and Admin Password$")
	public void enter_the_Admin_Email_Id_and_Admin_Password() throws Throwable {
		driver.findElement(By.id("userEmail")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
	  
	}

	@When("^Click On Login Button for Admin Login$")
	public void click_On_Login_Button_for_Admin_Login() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[2]")).click();
	    
	}

	@When("^Admin Home Page Opened Then Click On The  Logout Button$")
	public void admin_Home_Page_Opened_Then_Click_On_The_Logout_Button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click();
	   
	}

	@Then("^Close The Driver$")
	public void close_The_Driver() throws Throwable {
		driver.close();
	    
	}

}
