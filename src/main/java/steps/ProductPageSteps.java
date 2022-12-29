package steps;

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

    @Then("add to cart success message with {string} text should be visible")
    public void verifyVisibilityOfCartMessage(String message) {
        Assert.assertEquals(productPage.getText(productPage.getAddedToCartMessage()), message, "Wrong message");
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
}
