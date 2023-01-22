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
    When user changes pagination to 36
    Then search results indicator should be equal to "23 Items"
    And number of elements on page should be equal to 23
#TODO Fix dropdown selection

  @Searching
  Scenario: Search for a phrase and changes pages
  https://magisterka.atlassian.net/browse/PRAC-14

    When user searches for "Tee"
    Then search results indicator should be equal to "Items 1-12 of 26"
    And number of elements on page should be equal to 12
    When user clicks next page arrow
    Then current page should be equal to 2
    And search results indicator should be equal to "Items 13-24 of 26"
    And number of elements on page should be equal to 12
    When user clicks previous page arrow
    Then current page should be equal to 1
    And search results indicator should be equal to "Items 1-12 of 26"
    When user goes to 3 rd page
    Then current page should be equal to 3
    And search results indicator should be equal to "Items 25-26 of 26"
    And number of elements on page should be equal to 2

  @Searching
  Scenario: Search for phrase and change sorting by Product Name
  https://magisterka.atlassian.net/browse/PRAC-26

    When user searches for "Jacket"
    And user sorts by "Product Name"
    Then product names should be sorted in "descending" order
    When user changes sorting order
    Then product names should be sorted in "ascending" order

  @Searching
  Scenario: Search for phrase and change sorting by Price
  https://magisterka.atlassian.net/browse/PRAC-28

    When user searches for "Jacket"
    And user sorts by "Price"
    Then prices should be sorted in "descending" order
    When user changes sorting order
    Then prices should be sorted in "ascending" order

  @Searching
  Scenario: Search for phrase and change displaying style
  https://magisterka.atlassian.net/browse/PRAC-30

    When user searches for "Jacket"
    Then displaying style should be set to Grid
    And search results indicator should be equal to "Items 1-12 of 23"
    When user changes displaying style to "List"
    Then displaying style should be set to List
    And search results indicator should be equal to "Items 1-10 of 23"

  @Searching
  Scenario: Search for phrase and verify Related search terms
  https://magisterka.atlassian.net/browse/PRAC-32

    When user searches for "Jacket"
    Then all Related Search Terms should contain "jacket" word

  @Searching
  Scenario: Open new collection page and verify filtering by price
  https://magisterka.atlassian.net/browse/PRAC-48

    When user clicks Shop New Yoga button
    And user expands shopping option named "Price"
    And user selects price filter option with following starting price "$50.00"
    Then search results indicator should be equal to "7 Items"
    And all products prices should be between 50.00 and 59.99