Feature: delete Supplier Product





  Scenario: Successfully delete Product
    Given I am logged in as an admin to delete a product
    When I serach by exist product Name
    And I click on the delete button
    Then I should see a confirmation message product has been deleted successfully


  Scenario: unsuccessfully delete product because missing name
    Given I am logged in as an admin to delete a product
    When I serach by miss product Name
    And I click on the delete button
    Then I should see an error message cant delete because missing name or non exist product Name


  Scenario: unsuccessfully delete product because non exist Dessert Name
    Given I am logged in as an admin to delete a product
    When I serach by non exist product Name
    And I click on the delete button
    Then I should see an error message cant delete because missing name or non exist product Name
