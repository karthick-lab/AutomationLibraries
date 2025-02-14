
@tag
Feature: Login


  Background:
  
    Given User have launched the application
    When I click on Login link


  #@tag2
  Scenario Outline: Title of your scenario outline
 # Given User have launched the application
 #   When I click on Login link
    When I enter "<username>" and "<password>"
    Then I verify the error message "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."	
    
    

    Examples: 
      | username  | password |
      | name1     |     5    |
      | name2     |     7    | 
