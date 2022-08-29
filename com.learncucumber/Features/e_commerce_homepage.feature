Feature: Components of home page are working fine
@ignore
	Scenario: Verify the items under my account option
		Given I am logged in to the application
		When I hover on my account a set of account trelated options open up
		Then I can verify if all the account related items are populating
		
	Scenario: Verify the categories of items displayed with image
		Given I am logged in to flipkart
		Then I will be able to view and click on all the categories of product
	
	Scenario: Verify if the user can Complete end to end ordering process
		Given I am in my home page and I searched a product
		When I click on the desired product
		Then I can click on add to cart button