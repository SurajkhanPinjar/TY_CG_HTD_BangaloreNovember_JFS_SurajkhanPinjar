package com.capgemini.forestrymanagementcucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = {"com.capgemini.forestrymanagementcucumber.stepdefinition"})   //glue : The operation we want to execute
public class TestRunner {

}
