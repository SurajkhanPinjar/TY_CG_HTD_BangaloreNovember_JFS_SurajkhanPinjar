Feature: Get All Appointments Details 

Scenario: Get All Appointments Test
	Given Open Chrome Browser and Enter The Url For Get All Appointment Details
	When Enter The Patient Id and Patient Password For Get All Appointment Details
	When Click On Login Button for For Get All Appointment Details
	When Patient Home Page Opened Then Click Book Now Doctor for Appointments
	Then In Side Bar Click On The Appointment Details 
	When All Appointments Are showing Then click On Logout button 
	Then Close The Driver For Get All Appointments