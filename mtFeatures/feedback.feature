

Feature:Feedback

  Scenario:Successfully add feedback
    Given i am on order page
    When i finsh order
    Then i add my feedback
    And i should see confirm message your feedback added successfully


  Scenario:unsuccessfully add feedback because missing enter feedback
    Given i am on order page
    When i finsh order
    Then i miss to add my feedback
    And i should see error message your feedback did not added successfully