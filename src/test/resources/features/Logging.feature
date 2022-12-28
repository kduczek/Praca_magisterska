Feature: Login to Juice Shop Application

  Background:
    Given User is on Luma Shop home page "https://magento.softwaretestingboard.com"

  @Login
  Scenario: Login with valid credentials
  https://magisterka.atlassian.net/browse/PRAC-4

    When user clicks on Sign In button from Top Menu
    And user enters valid credentials into login and password inputs
    And user clicks on Sign In button
    Then greetings message "Welcome, Selenium Test!" should be visible in Top Menu


