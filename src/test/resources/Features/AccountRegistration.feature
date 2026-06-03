# filename: AccountRegistration.feature

Feature: Account Registration on LetsShop

  Scenario: Successfully register a new user on LetsShop
    Given I navigate to the LetsShop registration page
    When  I enter first name "John"
    And   I enter last name "Doe"
    And   I enter email "johndoe_test@example.com"
    And   I enter phone number "1234567890"
    And   I select occupation "Student"
    And   I select gender "Male"
    And   I enter password "Test@1234"
    And   I confirm password "Test@1234"
    And   I check the age confirmation checkbox
    And   I click the Register button
    Then  I should see a successful registration confirmation
