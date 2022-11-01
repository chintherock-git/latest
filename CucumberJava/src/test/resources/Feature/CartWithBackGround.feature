Feature: This feature verifies amazon search with filter

  Background: user has opened Amazon website
    Given user has opened website
    Then searches for "Wrist Watches"
    Then selects Brand as "Titan"
    And selects Display as "Analogue"
    And select Brand Material as "Leather"
    And selects Discount as "25% Off or more"

  @test
   Scenario: Fetch the nth element from the search
    Given fetch element5 from the search
    Then store the product5 details in file
	  Then validate product5 type "Analog"
	  Then validate product5 material "Leather"
    Then validate product5 brand "Titan"
    Then validate product5 discount 25
    Then validate product5 delivery "Free Delivery"
    And validate product5 order "Fulfilled" by amazon
    
    @test
   Scenario: Fetch the nth element from the search
    Given fetch element10 from the search
    Then store the product10 details in file
	  Then validate product10 type "Analog"
	  Then validate product10 material "Leather"
    Then validate product10 brand "Titan"
    Then validate product10 discount 25
    Then validate product10 delivery "Free Delivery"
    And validate product10 order "Fulfilled" by amazon
    
    @test
   Scenario: Fetch the nth element from the search
    Given fetch element15 from the search
    Then store the product15 details in file
	  Then validate product15 type "Analog"
	  Then validate product15 material "Leather"
    Then validate product15 brand "Titan"
    Then validate product15 discount 25
    Then validate product15 delivery "Free Delivery"
    And validate product15 order "Fulfilled" by amazon