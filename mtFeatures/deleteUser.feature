Feature: Delete User


  Scenario: Successfully delete user
    Given I am logged in as an administrator
    When I search about specific username
    And click the Delete button
    Then I should see a confirmation message User old_user has been successfully deleted


  Scenario: unsuccessfully delete user because non-existent user
    Given I am logged in as an administrator
    When I search about non-existent username
    And I click the Delete button
    Then I should see an error message cant delete because missing name or non-existent user



  Scenario: unsuccessfully delete user because missing username
    Given I am logged in as an administrator
    When I serach about missing username
    And click the Delete button
    Then I should see an error message cant delete because missing name or non-existent user