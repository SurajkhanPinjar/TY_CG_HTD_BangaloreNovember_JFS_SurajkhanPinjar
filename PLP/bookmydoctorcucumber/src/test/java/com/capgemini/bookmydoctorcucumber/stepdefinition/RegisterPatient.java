package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterPatient {
	
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Patient Sign Up$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Patient_Sign_Up() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/div[2]/div/div")).click();
	  
	}

	@Then("^Click on The Patient Sign Up Button$")
	public void click_on_The_Patient_Sign_Up_Button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/div[2]/div/div/a")).click();
	   
	}

	@When("^Sign Up Page Opened For Patient sign up Enter The Email Id and Password$")
	public void sign_Up_Page_Opened_For_Patient_sign_up_Enter_The_Email_Id_and_Password() throws Throwable {
		driver.findElement(By.id("userName")).sendKeys("Dheeksha");
		driver.findElement(By.id("userEmail")).sendKeys("deekshasingh@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Deeksha@123");	   
	}

	@When("^Click On the Sign Up Button For Patient Account$")
	public void click_On_the_Sign_Up_Button_For_Patient_Account() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-register-patient/div/div/div/form/button[1]")).click();	    
	}

	@Then("^Close The Driver for Patient Signup$")
	public void close_The_Driver_for_Patient_Signup() throws Throwable {
		driver.close();
	}



}
