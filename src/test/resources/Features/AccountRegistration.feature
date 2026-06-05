# filename: registration.feature

Feature: User Registration on LetsShop

  Scenario: Successfully register a new user on LetsShop
    Given I navigate to the registration page
    When I fill in the registration form
    And I submit the form
    Then I should be registered successfully
