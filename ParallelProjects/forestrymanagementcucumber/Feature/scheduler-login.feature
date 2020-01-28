Feature: Scheduler Login Features

Scenario: Test Scheduler Login with Valid Credentials
		Given Open Chrome  and enter Url for Scheduler
		When Enter valid Scheduler username and Password
		When Click on the Login Button Scheduler
		And Click The logout Button for Scheduler
		Then Close the driver for Scheduler