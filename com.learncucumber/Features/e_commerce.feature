Feature: Login functionality of flipkart
  @ignore
  Scenario: Login using username and password
    Given I open browser and login
    When I have correct username "<username>" and password "password"
    Then I should be able to login successfully
    
    Examples:
    | username                | password |
    | soumeshbasu22@gmail.com | sbm1997@ |
    | 9339534464              | bnm1998@ |
   @ignore
   Scenario: OTP Login if Login not successful due to invalid credentials
   	Given I open browser and login to flipkart
   	Given I tried logging in with my credentials "7001437585","jhdfjh"
   	When I get an error
   	Then I try login with OTP option "7001437585","4","7","5","2","9","4"
   	Then OTP login was sucessful "Nandita" or "My Account"
   	@ignore
   	Scenario: Sign up if the number is not registered
   		Given I try to login with a new number
   		When The number should display as not registered
   		Then I should be able to sign up to flipkart with "538856","Raju1009@"
   	@ignore
   	Scenario: Newly registered user can login and search for products
   		Given I get logged in successfully with username and password "<username>","<password>"
   		Then Ishould be able to search for products
    	And I should be able to sort the products
   
   