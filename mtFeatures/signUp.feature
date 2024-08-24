Feature: SignUp

   Scenario: SignUp successfully
    Given the user is on the SignUp page
    When the user provides username
    And the user provides valid email
    And the user provides strong password
    And hit the register button
    Then the user account is created successfully



  Scenario: SignUp with missing email
    Given the user is on the SignUp page
    When the user submits the SignUp form with missing email
    Then the system displays error messages for the missing fields

  Scenario: SignUp with existing email
    Given the user is on the SignUp page
    And an existing user with email
    When the user provides a contact email that is already registered
    Then the system displays an existing contact email error message



  Scenario: SignUp with missing username
    Given the user is on the SignUp page
    When the user provides valid email
    And the user submits the SignUp form with missing username
    Then the system displays error messages for the missing fields



  Scenario: SignUp with missing password
    Given the user is on the SignUp page
    When the user provides valid email
    And the user provides username
    And the user submits the SignUp form with missing password
    Then the system displays error messages for the missing fields

  Scenario: SignUp with weak password
    Given the user is on the SignUp page
    When the user provides valid email
    And the user provides username
    And the user provides a password that is too short
    Then the system displays a weak password error message says

