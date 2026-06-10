# filename: registration.feature

Feature: User Registration on LetsShop

  @Positive
  Scenario: Successfully register a new user on LetsShop
    Given I navigate to the registration page
    When I fill in the registration form
    And I submit the form
    Then I should be registered successfully

  @Negative
  Scenario: Verify error message when an already registered user attempts to register again
    When a user is already registered and attempts to register himself
    Then an error message saying user already exists displays