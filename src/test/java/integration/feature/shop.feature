Feature: Shop
  As a user
  I want to browse through all products
  So that I can buy the ones I like

  Scenario: Browse products
    When I ask for the products
    Then I get a '2' results
