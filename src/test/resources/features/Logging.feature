Feature: Login to Juice Shop Application

  Background:
    Given user is on Luma Shop home page "https://magento.softwaretestingboard.com"

#  @Login
#  Scenario: Login with valid credentials
#  https://magisterka.atlassian.net/browse/PRAC-4
#
#    When user clicks on Sign In button from Top Menu
#    And user enters valid credentials into login and password inputs
#    And user clicks on Sign In button
#    Then greetings message "Welcome, Selenium Test!" should be visible in Top Menu

  @Login
  Scenario: Login with valid credentials and log out
  https://magisterka.atlassian.net/browse/PRAC-8

    When user clicks on Sign In button from Top Menu
    And user enters valid credentials into login and password inputs
    And user clicks on Sign In button
    Then greetings message "Welcome, Selenium Test!" should be visible in Top Menu
    When user clicks on arrow next to greetings message to open dropdown
    And user clicks on Sign Out button
    Then "You are signed out" header should be visible
    When user waits 6 seconds
    Then "You are signed out" header should not be visible
    And default greetings message should be visible in Top Menu