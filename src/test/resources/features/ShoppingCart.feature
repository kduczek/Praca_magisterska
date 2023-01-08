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
    And number of products in cart should be equal to 2

  @Searching @ShoppingCart @ProductPage
  Scenario: Search for a product, add it to the cart and then remove
  https://magisterka.atlassian.net/browse/PRAC-34

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on "S" size
    And user clicks on "Green" color
    And user inputs 1 into Qty field
    And user clicks Add to Cart button
    Then product page success message with "You added Layla Tee to your shopping cart." text should be visible
    And number of products in cart should be equal to 1
    When user clicks shopping cart icon
    And user clicks delete icon in shopping cart
    And user allows deleting item from cart
    Then shopping cart should be empty

  @Searching @ShoppingCart @ProductPage
  Scenario: Search for a product, add it to the cart, click remove icon and the decline removing
  https://magisterka.atlassian.net/browse/PRAC-36

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on "S" size
    And user clicks on "Green" color
    And user inputs 1 into Qty field
    And user clicks Add to Cart button
    Then product page success message with "You added Layla Tee to your shopping cart." text should be visible
    And number of products in cart should be equal to 1
    When user clicks shopping cart icon
    And user clicks delete icon in shopping cart
    And user declines deleting item from cart
    Then number of products in cart should be equal to 1

  @Searching @ShoppingCart @ProductPage
  Scenario: Search for a product, add it to the cart, and verify Cart Subtotal
  https://magisterka.atlassian.net/browse/PRAC-38

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on "S" size
    And user clicks on "Green" color
    And user inputs 1 into Qty field
    And user clicks Add to Cart button
    Then product page success message with "You added Layla Tee to your shopping cart." text should be visible
    And number of products in cart should be equal to 1
    When user clicks shopping cart icon
    Then Cart Subtotal should be equal to "$29.00"

  @Searching @ShoppingCart @ProductPage
  Scenario: Search for a product, add it to the cart, and verify Cart Subtotal after updating Quantity
  https://magisterka.atlassian.net/browse/PRAC-40

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on "S" size
    And user clicks on "Green" color
    And user inputs 1 into Qty field
    And user clicks Add to Cart button
    Then product page success message with "You added Layla Tee to your shopping cart." text should be visible
    And number of products in cart should be equal to 1
    When user clicks shopping cart icon
    Then Cart Subtotal should be equal to "$29.00"
    When user sets Quantity in shopping cart to 3
    And user clicks Update button in cart
    And user waits 4 seconds
    Then number of products in cart should be equal to 3
    And Cart Subtotal should be equal to "$87.00"

  @Searching @ShoppingCart @ProductPage
  Scenario: Search for a product, add it to the cart, and verify its Details
  https://magisterka.atlassian.net/browse/PRAC-42

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on "S" size
    And user clicks on "Green" color
    And user inputs 1 into Qty field
    And user clicks Add to Cart button
    Then product page success message with "You added Layla Tee to your shopping cart." text should be visible
    And number of products in cart should be equal to 1
    When user clicks shopping cart icon
    And user clicks See Detail pane in Cart
    Then size in expanded details should be "S"
    And color in expanded details should be "Green"