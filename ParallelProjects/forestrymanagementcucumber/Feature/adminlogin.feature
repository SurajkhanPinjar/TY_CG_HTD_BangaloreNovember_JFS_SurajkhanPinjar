Feature: Admin Login

Scenario: Test Login with Valid Credentials
		Given Open Chrome  and enter Url 
		When Enter valid username and Password
		When Click on the Login
		And Click The logout Button
		Then Close the driver
		