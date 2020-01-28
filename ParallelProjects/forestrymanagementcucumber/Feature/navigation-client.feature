Feature: Navigation in Client Feature

Scenario: Navigation Test for Client Module
	Given Open Browser and Enter Enter Valid URL for Navigation of Client
	When Login with valid Client Account for Navigation of Client
	Then Click on Customer Button in Client Module and select add Customer
	Then Click on the Contracts Button in Client Module and select add Contracts
	Then Click on the Products Button in Client Module and click on all Products
	And Click On Logout Button for Client Module
	Then Close the Browser for Client Module