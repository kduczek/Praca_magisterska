package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductPage;

public class ProductPageSteps {
    ProductPage productPage = new ProductPage();

    @When("user clicks on {string} size")
    public void pickSize(String size) {
        productPage.clickElement(productPage.getSizeButton(size));
    }

    @When("user clicks on {string} color")
    public void pickColor(String color) {
        productPage.clickElement(productPage.getColorButton(color));
    }

    @When("user inputs {int} into Qty field")
    public void inputQty(int qty) {
        productPage.clearInput(productPage.getQuantityInput());
        productPage.inputValue(productPage.getQuantityInput(), String.valueOf(qty));
    }

    @When("user clears Qty field")
    public void clearQty() {
        productPage.clearInput(productPage.getQuantityInput());
    }

    @When("user clicks Add to Cart button")
    public void clickAddToCart() {
        productPage.clickElement(productPage.getAddToCartButton());
    }

    @Then("product page success/failure message with {string} text should be visible")
    public void verifyVisibilityOfMessagePrompt(String message) {
        productPage.waitForPageToLoad();
        productPage.waitForElementIsVisible(productPage.getProductPageMessagePrompt(), 5, 500);
        Assert.assertEquals(productPage.getText(productPage.getProductPageMessagePrompt()), message, "Wrong message");
    }

    @Then("validation message \"This is a required field.\" should be visible")
    public void verifyVisibilityOfValidationMessage() {
        Assert.assertTrue(productPage.isElementVisible(productPage.getRequiredFieldError()), "Validation message wasn't visible");
    }

    @Then("validation message \"This is a required field.\" should not be visible")
    public void verifyInvisibilityOfValidationMessage() {
        Assert.assertFalse(productPage.isElementVisible(productPage.getRequiredFieldError()), "Validation message wasn't visible");
    }

    @Then("quantity error message with {string} text should be visible")
    public void verifyQuantityMessage(String message) {
        Assert.assertEquals(productPage.getText(productPage.getQuantityError()), message, "Error message was different");
    }

    @When("user clicks Add to wish list button")
    public void clickAddToWishList() {
        productPage.clickElement(productPage.getAddToWishListButton());
    }

    @When("user clicks Add to compare button")
    public void clickAddToCompare() {
        productPage.clickElement(productPage.getAddToCompareButton());
    }

    @When("user clicks on Reviews tab")
    public void clickReviewsTab() {
        productPage.clickElement(productPage.getReviewsTab());
    }

    @When("user selects {int} star(s)")
    public void selectStars(int countOfStars) {
        productPage.pickStars(countOfStars);
    }

    @When("user fills review fields as follows")
    public void fillReviewFields(DataTable dataTable) {
        productPage.fillReviewFields(dataTable);
    }

    @When("user clicks Submit Review button")
    public void clickSubmitReviewButton() {
        productPage.clickElement(productPage.getSubmitReviewButton());
    }

    @Then("\"Be the first to review this product\" message should be visible")
    public void verifyNoReviewMessage() {
        Assert.assertTrue(productPage.isElementVisible(productPage.getNoReviewsInfo()), "Message wasn't visible");
    }
}
