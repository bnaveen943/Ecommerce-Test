#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

#@tag1
 # Scenario: Title of your scenario
  #  Given I want to write a step with precondition
   # And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes 

@tag
Feature: Purchase the order from Ecommerce application
  I want to use this template for my feature file

  Background:
  Given I Land on Ecommerce login page

  @tag2
  Scenario Outline: Postive test of purchasing the order
    Given Logged in with username <name> and password <password>
    When Add the product into cart <productName>
    And check out this product <productName> and submit the order.
    Then "THANKYOU FOR THE ORDER." message is displayed on configuration.
    
    Examples: 
      | name             | password     | productName  |
      | hnaveen@gmail.com|  Naveen0071@ | ZARA COAT 3  |
      
