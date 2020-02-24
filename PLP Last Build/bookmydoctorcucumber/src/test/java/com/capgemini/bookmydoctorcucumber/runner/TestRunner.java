package com.capgemini.bookmydoctorcucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = { "com.capgemini.bookmydoctorcucumber.stepdefinition" })
public class TestRunner {

}

