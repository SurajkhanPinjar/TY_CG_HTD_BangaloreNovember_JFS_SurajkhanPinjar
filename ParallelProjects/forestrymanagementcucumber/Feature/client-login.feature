Feature: Client Login Features

Scenario: Test Client Login with Valid Credentials
		Given Open Chrome  and enter Url for Client
		When Enter valid Client username and Password
		When Click on the Login Button Client
		And Click The logout Button for Client
		Then Close the driver for Client