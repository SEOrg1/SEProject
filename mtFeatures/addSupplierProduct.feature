Feature: Add Supplier Product

  Background:
    Given I am logged in as an supplier


  Scenario: Successfully add a supplier product
    Given I am on the Add Supplier product
    When I add product Name
    And I add supplier name for product
    And I add Price for product
    And I click the Add product button
    Then I should see a confirmation message product has been added successfully


  Scenario:unsuccessfully add a supplier product because missing product name
    Given I am on the Add Supplier product
    When I miss to add product Name
    And I add supplier name for product
    And I add Price for product
    And I click the Add product button
    Then I should see an error message can't add because missing some fields or non exist supplier



  Scenario:unsuccessfully add a supplier product because missing product supplier name
    Given I am on the Add Supplier product
    When I add product Name
    And I miss to add supplier name for product
    And I add Price for product
    And I click the Add product button
    Then I should see an error message can't add because missing some fields or non exist supplier


  Scenario:unsuccessfully add a supplier product because supplier name does not exist
    Given I am on the Add Supplier product
    When I add product Name
    And I add non exist supplier name for product
    And I add Price for product
    And I click the Add product button
    Then I should see an error message can't add because missing some fields or non exist supplier

  Scenario:unsuccessfully add a supplier product because missing product price
    Given I am on the Add Supplier product
    When I add product Name
    And I add supplier name for product
    And I miss to add Price for product
    And I click the Add product button
    Then I should see an error message can't add because missing some fields or non exist supplier




