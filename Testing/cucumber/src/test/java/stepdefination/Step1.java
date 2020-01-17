package stepdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step1 {

	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void before() {
		
	}
	
	@Given("^user Navigate to Login Page$")
	public void user_is_on_Home_Page()  {
		driver.get("https://www.bluestone.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User enters credentials to login$")
	public void user_Navigate_to_login_Page(DataTable usercredentials) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<List<String>> data = usercredentials.raw();
		
		driver.findElement(By.className("username")).sendKeys(data.get(0).get(0));\
		
		driver.findElement(By.xpath("//input[@name='pwd")).sendKeys((data.get(0)).get(1));
		
		driver.findElement(By.id("loginButton")).click();
		driver.get("https://www.bluestone.com/jewellery/bangles-men.html");
		
	}

	@When("^User search for Kadas\\.$")
	public void user_search_for_Kadas() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("submit_search")).click();
		Actions a = new Actions(driver);
		
		throw new PendingException();
	}

	@When("^User Selects one item\\.$")
	public void user_Selects_one_item() throws Throwable {
	    throw new PendingException();
	}

	@When("^User clicks on Buy Now button\\.$")
	public void user_clicks_on_Buy_Now_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Error message should be displayed\\.$")
	public void error_message_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
