package stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	
	ChromeDriver driver ;
	
	@Before
	public void beforeAnnotation() {
		driver = new ChromeDriver();
	}

	
	
	
	@Given("^User navigate to login page$")
	public void user_navigate_to_login_page() {
		driver.get("https://demo.actitime.com/login.do");
	}

//	@When("^User enters \"(.*)\" and \"(.*)\"$")  				//Recieving data from feature file
	@When("^User enters username \"(.*)\" and password\"(.*)\"$")  				//Recieving data from feature file
	public void user_enters_username_and_password(String un, String ps) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(ps);
		driver.findElement(By.id("loginButton")).click();
		
	}

	@Then("^Login should be Successful$")
	public void login_should_be_Successful() throws InterruptedException {
		Thread.sleep(5000);
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "actiTIME - Enter Time-Track");
		System.out.println("Login Successful");
	}
	
	@After
	public void afterAnnotation() {
		driver.close();
	}


}
