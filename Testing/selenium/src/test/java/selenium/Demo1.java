package selenium;

public class Demo1 {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	public static void main(String[] args) {
		TestAnnot t = new TestAnnot();
		t.demo1();
	}
}
