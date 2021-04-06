Feature: login
  testing if the log is successful


  Scenario: Submit subscription
    Given a Höffner login page
    When I open a page
    Then I can see a newsletter subscription input
    When  enter my email in the input field
    And I press Absenden button
    Then I can see a confirmation message that my subscription is in progress