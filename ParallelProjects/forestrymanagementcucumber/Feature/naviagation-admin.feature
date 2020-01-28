Feature: Navigation in Admin Feature

Scenario: Navigation Test
	Given Open Browser and Enter Enter Valid URL for Navigation
	When Login with valid Admin Account for Navigation 
	Then Click on Customer Button
	Then Click on the Contracts Button
	Then Click on the Products Button
	Then Click on Land Button
	Then Click on Accounts
	And Click On Logout Button
	Then Close the Browser