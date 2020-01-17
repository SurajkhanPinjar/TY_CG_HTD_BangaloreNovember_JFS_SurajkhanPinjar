package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/feature/Feature1.feature", glue = "stepdefination", plugin = {"pretty","html:target/cucumber"}, monochrome = true)
public class Runner1 extends AbstractTestNGCucumberTests{

}
