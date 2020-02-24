package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DoctorLogin {
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Doctor Login$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Doctor_Login() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
	   
	}

	@When("^Enter The Doctor Email Id and Doctor Password$")
	public void enter_The_Doctor_Email_Id_and_Doctor_Password() throws Throwable {
		//driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("userEmail")).sendKeys("doctor@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Doctor@123");
	   
	}

	@When("^Click On Login Button for Doctor Login$")
	public void click_On_Login_Button_for_Doctor_Login() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
	   
	}

	@When("^Doctor Home Page Opened Then Click On the Logout Button$")
	public void doctor_Home_Page_Opened_Then_Click_On_the_Logout_Button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click();
	}

	@Then("^Close The Driver for Doctor Login$")
	public void close_The_Driver_for_Doctor_Login() throws Throwable {
		driver.close();
	    
	    
	}

}
