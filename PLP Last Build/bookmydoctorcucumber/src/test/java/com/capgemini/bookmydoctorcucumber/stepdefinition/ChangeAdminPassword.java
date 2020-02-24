package com.capgemini.bookmydoctorcucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangeAdminPassword {
	WebDriver driver;
	@Given("^Open Chrome Browser and Enter The Url For Change Password For Admin$")
	public void open_Chrome_Browser_and_Enter_The_Url_For_Change_Password_For_Admin() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	   
	}

	@When("^Enter The Admin Id and Admin Password For Change Password For Admin$")
	public void enter_The_Admin_Id_and_Admin_Password_For_Change_Password_For_Admin() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[1]/a")).click();
		//driver.findElement(By.xpath("/html/body/app-root/app-header/nav[2]/div[2]/ul/li[1]/a")).click();
		driver.findElement(By.id("userEmail")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("admin123");
		//driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[2]/input")).click();
	   
		
		///html/body/app-root/app-admin-nav/div
	}

	@When("^Click On Login Button for For Change Password For Admin$")
	public void click_On_Login_Button_for_For_Change_Password_For_Admin() throws Throwable {
          
		driver.findElement(By.xpath("/html/body/app-root/app-login-user/div/div/div/form/div[3]/button")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[2]")).click();
		
	}

	@When("^Admin Home Page in Left side Bar Click On the Change Password$")
	public void admin_Home_Page_in_Left_side_Bar_Click_On_the_Change_Password() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/div/a[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/app-update-login/div/div/form/div[3]/input")).click();
	    
	}

	@Then("^Type New Password In Admin Change Password Field$")
	public void type_New_Password_In_Admin_Change_Password_Field() throws Throwable {
		//driver.findElement(By.id("userPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/app-update-login/div/div/form/div[3]/input")).click();
	   
	}

	@Then("^Click On Change Password Button For Admin$")
	public void click_On_Change_Password_Button_For_Admin() throws Throwable {  
		driver.findElement(By.xpath("/html/body/app-root/app-admin-nav/app-update-login/div/div/form/button")).click();
	}

	@When("^Then click On Logout button  for Admin Change Password$")
	public void then_click_On_Logout_button_for_Admin_Change_Password() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav[1]/div/ul/li[2]/a")).click();
	}

	@Then("^Close The Driver For Get Change Password For Admin$")
	public void close_The_Driver_For_Get_Change_Password_For_Admin() throws Throwable {
		driver.close();
	    
	}

}
