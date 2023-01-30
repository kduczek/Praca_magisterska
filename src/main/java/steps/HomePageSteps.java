package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.TopMenuPage;

import static pages.DriverProvider.getDriver;

public class HomePageSteps {
    private final TopMenuPage topMenuPage = new TopMenuPage();
    private final HomePage homePage = new HomePage();

    @Given("user is on Luma Shop home page")
    public void openBasePage() {
        getDriver().get("https://magento.softwaretestingboard.com");
    }

    @Then("default greetings message should be visible in Top Menu")
    public void verifyVisibilityOfDefaultGreetingsMessage() {
        Assert.assertTrue(topMenuPage.isElementVisible(topMenuPage.getDefaultGreetingsSpan()),
                "Default greetings message wasn't visible");
    }

    @When("user clicks on arrow next to greetings message to open dropdown")
    public void clickOnArrowToExpandAccordion() {
        topMenuPage.clickElement(topMenuPage.getCustomerMenuArrow());
    }

    @Then("greetings message {string} should be visible in Top Menu")
    public void verifyGreetingsMessage(String message) {
        topMenuPage.waitUntilTextEquals(topMenuPage.getGreetingsSpan(), "Default welcome msg!");
        Assert.assertEquals(topMenuPage.getText(topMenuPage.getGreetingsSpan()), message, "Wrong greeting message");
    }

    @When("user clicks on Sign Out button")
    public void clickOnSignOut() {
        topMenuPage.clickElement(topMenuPage.getSignOutButton());
    }

    @Then("\"You are signed out\" header should be visible")
    public void verifyVisibilityOfSignedOutHeader() {
        Assert.assertTrue(homePage.isElementVisible(homePage.getSignedOutMessage()), "Signed out message wasn't visible");
    }

    @Then("\"You are signed out\" header should not be visible")
    public void verifyIfSignedOutHeaderIsNotVisible() {
        Assert.assertFalse(homePage.isElementVisible(homePage.getSignedOutMessage()), "Signed out message was visible");
    }

    @When("user searches for {string}")
    public void searchFor(String item) {
        topMenuPage.searchForItem(item);
    }

    @When("user clicks Shop New Yoga button")
    public void clickShopNewYogaButton() {
        homePage.clickElement(homePage.getShopNewYogaButton());
    }
}
