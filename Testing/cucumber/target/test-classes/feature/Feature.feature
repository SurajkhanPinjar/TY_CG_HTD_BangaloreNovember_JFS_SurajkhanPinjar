Feature: Login Action				
		
@Smoke
Scenario:
		Given User Navigate to Login Page
		when User enters credentials to login 
		| admin | manager |
		Then Message displayed Login Successfully