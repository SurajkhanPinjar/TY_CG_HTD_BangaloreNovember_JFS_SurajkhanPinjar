package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "./src/test/java/feature/Feature.feature", glue = "stepdefination", 
				plugin = {"pretty","html:target/cucumber"}, monochrome = true)							//Configuration and mentioning path of the feature file
public class Runner extends AbstractTestNGCucumberTests{
		
	
}
