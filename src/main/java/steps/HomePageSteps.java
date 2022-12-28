package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.TopMenuPage;

import static pages.DriverProvider.getDriver;

public class HomePageSteps {
    private final TopMenuPage topMenuPage = new TopMenuPage();

    @Given("User is on Luma Shop home page {string}")
    public void openBasePage(String url) {
        getDriver().get(url);
    }

    @Then("greetings message {string} should be visible in Top Menu")
    public void verifyGreetingsMessage(String message) {
        topMenuPage.waitUntilTextEquals(topMenuPage.getGreetingsSpan(), "Default welcome msg!");
        Assert.assertEquals(topMenuPage.getText(topMenuPage.getGreetingsSpan()), message, "Wrong greeting message");
    }
}
