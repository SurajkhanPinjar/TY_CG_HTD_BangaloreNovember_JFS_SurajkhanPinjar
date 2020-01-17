package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
//import org.testng.Reporter;
//import org.testng.annotations.Test;

public class TestAnnot {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	@Test
	public void demo1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		Reporter.log("from testannot demo1", true);
			
	}
}
