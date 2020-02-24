Feature: Patient Login 

Scenario: Patient Login Test 
	Given Open Chrome Browser and Enter The Url For Patient Login 
	When Enter The Patient Email Id and Patient Password 
	When Click On Login Button for Patient Login 
	When Patient Home Page Opened Then Click On the Logout Button 
	Then Close The Driver for Patient Login