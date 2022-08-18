Feature: Components of home page are working fine
@ignore
	Scenario: Verify the items under my account option
		Given I am logged in to the application
		When I hover on my account a set of account trelated options open up
		Then I can verify if all the account related items are populating
	@ignore	
	Scenario: Verify the categories of items displayed with image
		Given I am logged in to flipkart
		Then I will be able to view and click on all the categories of product