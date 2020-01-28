package com.capgemini.forestrymanagementcucumber.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@CucumberOptions(features = ".//Feature",
				glue = "com.capgemini.forestrymanagementcucumber.stepdefinition", 
				plugin = {"pretty" ,"html:target/cucumber"}, monochrome = true)
public class Runner  {
	
	WebDriver driver;
	
	@Given("Opening in google")
	public void openGoogle() {
		System.out.println("Open Google");
		System.setProperty("webdriver.chrome.driver", "/forestrymanagementcucumber/src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
	}
	
	@When("Searching In google")
	public void searchGoogle() {
		System.out.println("Search Google");
		driver.findElement(By.name("q")).sendKeys("selenium");
	}
	
	@Then("closing google")
	public void closeGoogle() {
		System.out.println("Close Google");
		driver.close();
	}

}
