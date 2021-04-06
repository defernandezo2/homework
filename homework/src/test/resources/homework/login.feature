Feature: login
  testing if the login is successful


  Scenario: Submit subscription
    Given a Höffner login page
    When I open a page
    Then I can see a newsletter subscription input
    When  enter my email in the input field
    And I press Absenden button
    Then I can see a confirmation message that my subscription is in progress

  Scenario: Wrong Submit subscription
    Given a Höffner login page
    When I open a page
    Then I can see a newsletter subscription input
    When  enter a wrong formatted email in the input field
    And I press Absenden button
    Then A Wrong Message Is Displayed

  Scenario Outline: Submit subscription different emails
    Given a Höffner login page
    When I open a page
    Then I can see a newsletter subscription input
    When  enter a valid "<email>" in the input field
    And I press Absenden button
    Then I can see a confirmation message that my subscription is in progress
    Examples:
      | email |
      | UPPER |
      | valid |
      | 12345 |
      | long  |
      | short |
