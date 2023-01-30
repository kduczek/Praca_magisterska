Feature: Product page in Luma Shop

  Background:
    Given user is on Luma Shop home page

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

  @Searching @ProductPage
  Scenario: Add product to comparison list
  https://magisterka.atlassian.net/browse/PRAC-22

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks Add to compare button
    Then product page success message with "You added product Layla Tee to the comparison list." text should be visible

  @Searching @ProductPage
  Scenario: User adds a review to the product
  https://magisterka.atlassian.net/browse/PRAC-24

    When user searches for "LAYLA"
    Then search results indicator should be equal to "1 Item"
    And number of elements on page should be equal to 1
    When user clicks on "Layla Tee" product link
    And user clicks on Reviews tab
    And user selects 4 stars
    And user fills review fields as follows
      | Nickname  | Summary    | Review                 |
      | Test user | My Summary | This is a nice T-Shirt |
    And user clicks Submit Review button
    Then product page success message with "You submitted your review for moderation." text should be visible

  @Searching @ProductPage
  Scenario: Verify the product without any review
  https://magisterka.atlassian.net/browse/PRAC-44

    When user searches for "Phoebe Zipper Sweatshirt"
    Then search results indicator should be equal to "Items 1-12 of 30"
    And number of elements on page should be equal to 12
    When user clicks on "Phoebe Zipper Sweatshirt" product link
    Then "Be the first to review this product" message should be visible