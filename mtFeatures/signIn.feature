Feature: Login

  Background:

   Scenario: Successful login
    Given the user has a valid username  and password
    When the user logs in with valid credentials
    Then the user should be logged in successfully

  Scenario: Failed login with incorrect password
    Given the user has a valid username  and incorrect password
    When the user logs in with invalid password
    Then the user should see an error message Login Failed

  Scenario: Failed login with incorrect username
    Given the user has an invalid username  and valid password
    When the user logs in with invalid username
    Then the user should see an error message Login Failed

  Scenario: Failed login with both incorrect username and password
    Given the user has an invalid username  and incorrect password
    When the user logs in with both invalid username and password
    Then the user should see an error message Login Failed

  Scenario: User provides empty credentials
    Given the user has empty username and password
    When the user tries to log in with empty credentials
    Then the user should see an error message Login Failed