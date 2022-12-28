Feature: Using search feature in Luma Shop

  Background:
    Given user is on Luma Shop home page "https://magento.softwaretestingboard.com"

  @Searching
  Scenario: Search for phrase and verify number of results
  https://magisterka.atlassian.net/browse/PRAC-10

    When user searches for "Stellar"
    Then search results indicator should be equal to "1 Item"
    When user searches for "Jacket"
    Then search results indicator should be equal to "Items 1-12 of 23"
    When user searches for "hghe456"
    Then "Your search returned no results." warning message should be visible