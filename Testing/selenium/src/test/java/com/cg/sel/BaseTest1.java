package com.cg.sel;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest1 {
	
	@BeforeSuite
	public void m1() {
		Reporter.log("@BeforreSuite", true);
	}
	
	@BeforeTest
	public void m2() {
		Reporter.log("@Before Test", true);
	}
	
	@BeforeClass
	public void m3() {
		Reporter.log("@BeforClass", true);
	}
	
	@BeforeMethod
	public void m4() {
		Reporter.log("@BeforeMethod", true);
	}
	
	@AfterSuite
	public void m5() {
		Reporter.log("@AfterSuite", true);
	}
	
	@AfterTest
	public void m6() {
		Reporter.log("@After Test", true);
	}
	
	@AfterClass
	public void m7() {
		Reporter.log("@AfterClass", true);
	}
	
	@AfterMethod
	public void m8() {
		Reporter.log("@AfterMethod", true);
	}

}
