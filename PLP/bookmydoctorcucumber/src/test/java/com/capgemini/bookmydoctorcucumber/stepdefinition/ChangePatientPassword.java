package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangePatientPassword {
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Change Password For Doctor$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Change_Password_For_Doctor() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	}

	@When("^Enter The Doctor Id and Doctor Password For Change Password For Doctor$")
	public void enter_The_Doctor_Id_and_Doctor_Password_For_Change_Password_For_Doctor() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
		driver.findElement(By.id("userEmail")).sendKeys("vidy@g.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vidya@123");
	   
	}

	@When("^Click On Login Button for For Change Password For Doctor$")
	public void click_On_Login_Button_for_For_Change_Password_For_Doctor() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();	
	}

	@When("^Doctor Home Page in Left side Bar Click On the Change Password$")
	public void doctor_Home_Page_in_Left_side_Bar_Click_On_the_Change_Password() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-patient-nav/a/button")).click();	
	
	   
	}

	@Then("^Type New Password In Doctor Change Password Field$")
	public void type_New_Password_In_Doctor_Change_Password_Field() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-doctors-info/a/button")).click();	

	    
	}

	@Then("^Click On Change Password Button For Doctor$")
	public void click_On_Change_Password_Button_For_Doctor() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-patient-inner-nav/div/a[3]")).click();	
		driver.findElement(By.xpath("/html/body/app-root/app-patient-inner-nav/app-update-login/div/div/form/div[3]/input")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-patient-inner-nav/app-update-login/div/div/form/button")).click();	
	   
	}

	@When("^Then click On Logout button  for Doctor Change Password$")
	public void then_click_On_Logout_button_for_Doctor_Change_Password() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click();	
	}

	@Then("^Close The Driver For Get Change Password For Doctor$")
	public void close_The_Driver_For_Get_Change_Password_For_Doctor() throws Throwable {
		driver.close();
	}
}
