package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ShoppingCartPage;
import pages.TopMenuPage;

public class ShoppingCartSteps {
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    TopMenuPage topMenuPage = new TopMenuPage();

    @When("user clicks shopping cart icon")
    public void clickShoppingCartIcon() {
        topMenuPage.clickElement(topMenuPage.getShoppingCartIcon());
    }

    @When("user clicks delete icon in shopping cart")
    public void clickDeleteIconInCart() {
        topMenuPage.clickElement(topMenuPage.getShoppingCartDeleteIcon());
    }

    @When("user allows deleting item from cart")
    public void allowToDeleteFromCart() {
        topMenuPage.clickElement(topMenuPage.getAllowDeletingFromCart());
    }

    @When("user declines deleting item from cart")
    public void declineToDeleteFromCart() {
        topMenuPage.clickElement(topMenuPage.getCancelDeletingFromCart());
    }

    @Then("number of products in cart should be equal to {int}")
    public void verifyNumberOfProductsInCart(int numberOfProducts) {
        Assert.assertEquals(topMenuPage.getText(topMenuPage.getShoppingCartCounter()), String.valueOf(numberOfProducts), "Wrong number of products in cart");
    }

    @Then("shopping cart should be empty")
    public void verifyIfCartIsEmpty() {
        topMenuPage.waitForPageToLoad();
        Assert.assertTrue(topMenuPage.isElementVisible(topMenuPage.getEmptyCartMessage()));
    }

    @Then("Cart Subtotal should be equal to {string}")
    public void verifyCartSubtotal(String expectedAmount) {
        Assert.assertEquals(topMenuPage.getText(topMenuPage.getShoppingCartSubtotal()), expectedAmount, "Wrong Cart Subtotal");
    }

    @When("user sets Quantity in shopping cart to {int}")
    public void setQuantityInCart(int newQuantity) {
        topMenuPage.changeQuantityInCart(newQuantity);
    }

    @When("user clicks Update button in cart")
    public void clickUpdateButton() {
        topMenuPage.clickElement(topMenuPage.getUpdateQuantityButton());
    }

    @When("user clicks See Detail pane in Cart")
    public void clickSeeDetails() {
        topMenuPage.clickElement(topMenuPage.getSeeDetailsSpan());
    }

    @Then("size in expanded details should be {string}")
    public void verifySize(String expectedSize) {
        Assert.assertEquals(topMenuPage.getText(topMenuPage.getDetailsSize()), expectedSize, "Wrong size");
    }

    @Then("color in expanded details should be {string}")
    public void verifyColor(String expectedColor) {
        Assert.assertEquals(topMenuPage.getText(topMenuPage.getDetailsColor()), expectedColor, "Wrong color");
    }
}
