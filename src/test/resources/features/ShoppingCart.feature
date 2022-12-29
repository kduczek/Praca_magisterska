Feature: Using shopping cart feature in Luma Shop

  Background:
    Given user is on Luma Shop home page "https://magento.softwaretestingboard.com"

  @Searching @ShoppingCart @ProductPage
  Scenario: Search for a product and add it to the cart
  https://magisterka.atlassian.net/browse/PRAC-16

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on "S" size
    And user clicks on "Green" color
    And user inputs 2 into Qty field
    And user clicks Add to Cart button
    Then product page success message with "You added Layla Tee to your shopping cart." text should be visible
