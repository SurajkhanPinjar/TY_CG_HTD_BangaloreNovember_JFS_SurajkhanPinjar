package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewAllAvailabity {
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Get All Availability Details$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Get_All_Availability_Details() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
	}

	@When("^Enter The Patient Id and Patient Password For Get All Availability Details$")
	public void enter_The_Patient_Id_and_Patient_Password_For_Get_All_Availability_Details() throws Throwable {
//		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[1]/input")).click();
//		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[2]/input")).click();
		driver.findElement(By.id("userEmail")).sendKeys("vidy@g.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vidya@123");
	    
	}

	@When("^Click On Login Button for For Get All Availability Details$")
	public void click_On_Login_Button_for_For_Get_All_Availability_Details() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
		
	    
	}

	@When("^Patient Home Page Opened Then Click Book Now Doctor for Appointments$")
	public void patient_Home_Page_Opened_Then_Click_Book_Now_Doctor_for_Appointments() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-patient-nav/a/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-doctors-info/a/button")).click();
		
	   
	}

	@Then("^In Side Bar Click On The Availability Details$")
	public void in_Side_Bar_Click_On_The_Availability_Details() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-patient-inner-nav/div/a[6]")).click();
	    
	}

	@When("^All Availability Are showing Then click On Logout button$")
	public void all_Availability_Are_showing_Then_click_On_Logout_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click();  
	}

	@Then("^Close The Driver For Get All Availability$")
	public void close_The_Driver_For_Get_All_Availability() throws Throwable {
		driver.close();
	   
	}

}
