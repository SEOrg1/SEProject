Feature: Update Dessert

  Scenario: Successfully Update Dessert
    Given I on update page
    When I search about specific dessert to update
    And click the serch button
    Then check if this dessert exist
    And enter the new value for all the attributs
    And I should see a confirmation message Dessert has been updated successfully


  Scenario: unsuccessfully Update Dessert because non-existent dessert
    Given I on update page
    When I search about non existent dessert to update
    And click the serch button
    Then I should see an error message cant update because missing name or non existent dessert


  Scenario: unsuccessfully Update Dessert
    Given I on update page
    When I search about missind dessert name to update
    And click the serch button
    Then I should see an error message cant update because missing name or non existent dessert