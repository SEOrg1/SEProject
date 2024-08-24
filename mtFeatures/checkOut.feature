Feature: checkOut



  Scenario:Successful check out
    Given the user has added items to their cart
    When they navigate to the checkout page
    And add his delivery information
    Then they should see all items in their cart including
    And see his information
    And see confirm message

  Scenario: Failed check out cause empty order
    Given the user didn't add any items
    When they navigate to the checkout page
    Then they should see error message