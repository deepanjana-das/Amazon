Feature: Amazon shopping Feature
  
  @SmokeSuite
  Scenario Outline: Ordering an item in Amazon
    Given User is on Amazon landing page on hitting "<amazonUrl>"
    When User clicks on sign in tab
    And User logs in by providing "<userid>" and "<password>"
    And User is on Amazon Home page with "<userid>"

    


    Examples: 
      |amazonUrl|userid|password|item-text|quantityNumber|
      |https://www.amazon.in/|deepanjana.cse@gmail.com|pinki123|saree|1|