package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PatientLogin {
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Patient Login$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Patient_Login() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
	    
	}

	@When("^Enter The Patient Email Id and Patient Password$")
	public void enter_The_Patient_Email_Id_and_Patient_Password() throws Throwable {
		driver.findElement(By.id("userEmail")).sendKeys("vidy@g.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vidya@123");
	    
	}

	@When("^Click On Login Button for Patient Login$")
	public void click_On_Login_Button_for_Patient_Login() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();	
		//driver.findElement(By.xpath("/html/body/app-root/app-header/nav[2]")).click();
	   
	}

	@When("^Patient Home Page Opened Then Click On the Logout Button$")
	public void patient_Home_Page_Opened_Then_Click_On_the_Logout_Button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click();
	    
	}

	@Then("^Close The Driver for Patient Login$")
	public void close_The_Driver_for_Patient_Login() throws Throwable {
		driver.close();
	}



}
