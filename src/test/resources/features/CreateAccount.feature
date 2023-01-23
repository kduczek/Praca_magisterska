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
