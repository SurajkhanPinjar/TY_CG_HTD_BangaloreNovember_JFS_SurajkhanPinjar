package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllDoctors {
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Get All Doctor Details$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Get_All_Doctor_Details() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("userEmail")).sendKeys("admin123@gmail.com");	
//		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[1]/input")).click();
//		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[2]/input")).click();
		driver.findElement(By.id("userPassword")).sendKeys("admin123");
	
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
	}

	@When("^Enter The Patient Id and Patient Password For Get All Doctor Details$")
	public void enter_The_Patient_Id_and_Patient_Password_For_Get_All_Doctor_Details() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div")).click();
		 
	}

	@When("^Click On Login Button for For Get All Doctor Details$")
	public void click_On_Login_Button_for_For_Get_All_Doctor_Details() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[2]")).click();  
	}

	@When("^Patient Home Page Opened Then Click Book Now Doctor$")
	public void patient_Home_Page_Opened_Then_Click_Book_Now_Doctor() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[2]")).click();
	    
	}

	@Then("^Click On Search Doctor Button  For Get All Doctor$")
	public void click_On_Search_Doctor_Button_For_Get_All_Doctor() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[2]")).click();
	}

	@Then("^In Side Bar Click On The Doctor Details$")
	public void in_Side_Bar_Click_On_The_Doctor_Details() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[2]")).click();
	}

	@When("^All Doctors Are showing Then click On Logout button$")
	public void all_Doctors_Are_showing_Then_click_On_Logout_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click(); 
		
	   
	}

	@Then("^Close The Driver For Get All Doctorssss$")
	public void close_The_Driver_For_Get_All_Doctorssss() throws Throwable {
		driver.close();
	}



}
