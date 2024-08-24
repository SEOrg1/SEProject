Feature: Report About Feature



  Scenario: Successfully generate Report
    Given I am on the Report page
    And there is order
    When  I click to generate order
    Then I should see deteails about every order


  Scenario: unsuccessfully generate Report
    Given I am on the Report page
    And there is no order
    When  I click to generate order
    Then I should see error message cannot generate report because there is no order


