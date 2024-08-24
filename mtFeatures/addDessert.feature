
    Feature: Add Dessert


    Background:
    Given I am logged in as an admin


    Scenario: Successfully add a new dessert to the menu
    Given I am on the Add Dessert page
    When I add  Dessert Name
    And I add  Description for dessert
    And I add  Price for dessert
    And I click the Add Dessert button
    Then I should see a confirmation message Dessert has been added successfully


    Scenario:unsuccessfully add a new dessert because missing name
    Given I am on the Add Dessert page
    When I add  Description for dessert
    And I add  Price for dessert
    And I click the Add Dessert button
    Then I should see an error message Dessert name is required

    Scenario:unsuccessfully add a new dessert because missing price
    Given I am on the Add Dessert page
    When I add  name for dessert
    And I add  Description for dessert
    And I click the Add Dessert button
    Then I should see an error message Dessert price is required