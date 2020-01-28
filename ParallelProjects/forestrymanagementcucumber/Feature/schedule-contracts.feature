Feature: Scheduler Contracts Feature

Scenario: Test Schedule Contracts 
		Given Open Chrome  and enter Url for Schedule Contracts
		When Login with Valid Scheduler Account to Schedule Contracts
		Then Click On Contracts and select schedule Contracts
		And Click on status field
		And Select Status as Approved
		Then Logout the Scheduler Account
		And Login as Client Account with valid Credentils
		Then Click on Contracts and Choose All Contracts check for Status
		Then Logout Client Account For Schedule Contracts
		Then Close The Browser For Schedule Contracts