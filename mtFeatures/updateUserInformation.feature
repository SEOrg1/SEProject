Feature: Update user

  Scenario: Successfully Update user
    Given I on update user page
    When I search about specific user to update
    And click the search button
    Then check if this user exist
    And enter the new value for all attributs
    And I should see a confirmation message user information has been updated successfully


  Scenario: unsuccessfully Update user because non-existent dessert
    Given I on update user page
    When I search about non existent user to update
    And click the search button
    Then I should see an error message cant update because missing name or non existent user


  Scenario: unsuccessfully Update user because missing name
    Given I on update user page
    When I search about missind user name to update
    And click the search button
    Then I should see an error message cant update because missing name or non existent user