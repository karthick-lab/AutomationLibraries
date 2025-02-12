
@tag
Feature: Registration


  #@tag1
  Background:
  
    Given User have launched the application
    When I click on Registration link
  
  Scenario: Validate fields in registration page
    
    And I enter the registration details
    |First Name|Last Name  |Email         |Telephone |Password    |ConfirmPassword|Subscribe|
    |Shayee    |Karthick   |test@gmail.com|1234567890|dGVzdEAxMjM=|dGVzdEAxMjM=   |yes      |
    |Shayee 1  |Karthick 1 |test@gmail.com|1234567890|dGVzdEAxMjM=|dGVzdEAxMjM=   |yes      |
     
    Then I validate the outcomes
    
   
    
    
    
    
    
  #@tag2
  #Scenario Outline: Title of your scenario outline
  #  Given I want to write a step with <name>
  #  When I check for the <value> in step
  #  Then I verify the <status> in step

  #  Examples: 
  #    | name  | value | status  |
  #    | name1 |     5 | success |
  #    | name2 |     7 | Fail    |
