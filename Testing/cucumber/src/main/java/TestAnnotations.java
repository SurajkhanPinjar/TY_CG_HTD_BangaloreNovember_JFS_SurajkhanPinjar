

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestAnnotations  {
	
	@Test
	public void demo1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		Reporter.log("from testannot demo1", true);
			
	}
	
 
	
	

}
