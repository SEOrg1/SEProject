Feature: delete Dessert

  Background:
    Given I am logged in as an admin to delete a dessert


  Scenario: Successfully delete dessert from menu
    Given I am logged in as an admin to delete a dessert
    When I serach by exist Dessert Name
    And I click the delete Dessert button
    Then I should see a confirmation message Dessert has been deleted successfully


  Scenario: unsuccessfully delete dessert from menu because missing name
    Given I am logged in as an admin to delete a dessert
    When I serach by miss Dessert Name
    And I click the delete Dessert button
    Then I should see an error message cant delete because missing name or not exist Dessert Name


  Scenario: unsuccessfully delete dessert from menu because not exist Dessert Name
    Given I am logged in as an admin to delete a dessert
    When I serach by not exist Dessert Name
    And I click the delete Dessert button
    Then I should see an error message cant delete because missing name or not exist Dessert Name