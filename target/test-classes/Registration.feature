
@tag
Feature: Registration


  #@tag1
 # Background:
  
#    Given User have launched the application
#When I click on Registration link
  
  Scenario: Validate fields in registration page
     Given User have launched the application
    When I click on Registration link
    And I enter the registration details
    |First Name|Last Name  |Email         |Telephone |Password    |ConfirmPassword|Subscribe|
    |Shayee    |Karthick   |test@gmail.com|1234567890|dGVzdEAxMjM=|dGVzdEAxMjM=   |yes      |
    |Shayee 1  |Karthick 1 |test@gmail.com|1234567890|dGVzdEAxMjM=|dGVzdEAxMjM=   |yes      |
     
    Then I validate the outcomes
    
  
