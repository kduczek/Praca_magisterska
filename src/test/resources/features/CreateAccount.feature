Feature: Create new user in Luma Shop

  Background:
    Given user is on Luma Shop home page "https://magento.softwaretestingboard.com"

  @Registration
  Scenario: Create new user
  https://magisterka.atlassian.net/browse/PRAC-54

    When user clicks Create an Account button from Top Menu
    And user inputs following details for new user
      | First Name | Last Name | Email    | Password        | Confirm Password |
      | John       | Kowalski  | [RANDOM] | testPassword789 | testPassword789  |
    And user clicks Create an Account button
    Then confirmation message after registering new account should be visible
    And greetings message "Welcome, John Kowalski!" should be visible in Top Menu
    And user should be moved to My Account page
    When user clicks on arrow next to greetings message to open dropdown
    And user clicks on Sign Out button
    Then "You are signed out" header should be visible

  @Registration
  Scenario: Verify validation message for all inputs on Create Account view
  https://magisterka.atlassian.net/browse/PRAC-56

    When user clicks Create an Account button from Top Menu
    Then validation messages for all inputs in Create Account should be "invisible"
    When user clicks Create an Account button
    Then validation messages for all inputs in Create Account should be "visible"

  @Registration
  Scenario: Verify validation message for Confirm Password input when password don't match
  https://magisterka.atlassian.net/browse/PRAC-58

    When user clicks Create an Account button from Top Menu
    And user inputs following details for new user
      | First Name | Last Name | Email    | Password        | Confirm Password  |
      | John       | Kowalski  | [RANDOM] | testPassword789 | WRONG_PASSWORD123 |
    And user clicks Create an Account button
    Then confirm password validation should be visible with text "Please enter the same value again."

  @Registration
  Scenario: Verify behavior of the Password Strength indicator
  https://magisterka.atlassian.net/browse/PRAC-60

    When user clicks Create an Account button from Top Menu
    Then Password Strength should be "No Password"
    When user inputs following details for new user
      | Password |
      | aaaaaa   |
    Then Password Strength should be "Weak"
    When user inputs following details for new user
      | Password |
      | LFap12@1 |
    Then Password Strength should be "Medium"
    When user inputs following details for new user
      | Password  |
      | RTas12%^2 |
    Then Password Strength should be "Strong"
    When user inputs following details for new user
      | Password    |
      | RTas12%^2jo |
    Then Password Strength should be "Very Strong"

  @Registration
  Scenario: Verify validation of the Password input
  https://magisterka.atlassian.net/browse/PRAC-62

    When user clicks Create an Account button from Top Menu
    And user inputs following details for new user
      | Password |
      | aaaaaa   |
    Then password validation should be visible with text "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."
    When user inputs following details for new user
      | Password |
      | aaaaaaaa |
    Then password validation should be visible with text "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."
    When user inputs following details for new user
      | Password              |
      | [SPACE][SPACE][SPACE] |
    Then password validation should be visible with text "This is a required field."

  @Registration
  Scenario: Register new user and Sign him to the Newsletter
  https://magisterka.atlassian.net/browse/PRAC-64

    When user clicks Create an Account button from Top Menu
    And user inputs following details for new user
      | First Name | Last Name | Email    | Password        | Confirm Password |
      | John       | Kowalski  | [RANDOM] | testPassword789 | testPassword789  |
    And user checks Sign Up for Newsletter checkbox
    And user clicks Create an Account button
    Then confirmation message after registering new account should be visible
    And greetings message "Welcome, John Kowalski!" should be visible in Top Menu
    And user should be moved to My Account page
    And Newsletter status should be equal to "You are subscribed to \"General Subscription\"."
    When user clicks on arrow next to greetings message to open dropdown
    And user clicks on Sign Out button
    Then "You are signed out" header should be visible