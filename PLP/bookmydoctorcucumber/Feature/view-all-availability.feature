Feature: Get All Appointments Details 

Scenario: Get All Availability Test 
	Given Open Chrome Browser and Enter The Url For Get All Availability Details 
	When Enter The Patient Id and Patient Password For Get All Availability Details 
	When Click On Login Button for For Get All Availability Details 
	When Patient Home Page Opened Then Click Book Now Doctor for Appointments 
	Then In Side Bar Click On The Availability Details 
	When All Availability Are showing Then click On Logout button 
	Then Close The Driver For Get All Availability