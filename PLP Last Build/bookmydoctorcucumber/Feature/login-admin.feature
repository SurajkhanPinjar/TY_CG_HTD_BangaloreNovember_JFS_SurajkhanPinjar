Feature: Admin Login 

Scenario: Admin Login Test 
	Given Open Chrome Browser and Enter The Url for Admin Login 
	When Enter the Admin Email Id and Admin Password 
	When Click On Login Button for Admin Login 
	When Admin Home Page Opened Then Click On The  Logout Button 
	Then Close The Driver 
          