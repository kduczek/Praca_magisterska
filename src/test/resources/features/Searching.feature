Feature: Using search feature in Luma Shop

  Background:
    Given user is on Luma Shop home page "https://magento.softwaretestingboard.com"

  @Searching
  Scenario: Search for phrase and verify number of results
  https://magisterka.atlassian.net/browse/PRAC-10

    When user searches for "Stellar"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user searches for "Jacket"
    Then search results indicator should be equal to "Items 1-12 of 23"
    And number of elements on page should be equal to 12
    When user searches for "hghe456"
    Then "Your search returned no results." warning message should be visible

  @Searching
  Scenario: Search for phrase and change pagination
  https://magisterka.atlassian.net/browse/PRAC-12

    When user searches for "Jacket"
    Then search results indicator should be equal to "Items 1-12 of 23"
    And number of elements on page should be equal to 12
    When user changes pagination to "36"
    Then search results indicator should be equal to "23 Items"
    And number of elements on page should be equal to 23
#TODO Fix dropdown selection