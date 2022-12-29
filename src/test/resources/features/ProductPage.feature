Feature: Product page in Luma Shop

  Background:
    Given user is on Luma Shop home page "https://magento.softwaretestingboard.com"

  @Searching @ProductPage
  Scenario: Verify validation messages in product page
  https://magisterka.atlassian.net/browse/PRAC-18

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks Add to Cart button
    Then validation message "This is a required field." should be visible
    When user clicks on "S" size
    And user clicks Add to Cart button
    Then validation message "This is a required field." should not be visible
    And user clicks on "Green" color
    When user inputs 0 into Qty field
    And user clicks Add to Cart button
    Then quantity error message with "Please enter a quantity greater than 0." text should be visible
    When user clears Qty field
    And user clicks Add to Cart button
    Then quantity error message with "Please enter a valid number in this field." text should be visible

  @Searching @ProductPage
  Scenario: Verify validation message when not logged user add product to wishlist
  https://magisterka.atlassian.net/browse/PRAC-20

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks Add to wish list button
    Then product page failure message with "You must login or register to add items to your wishlist." text should be visible
