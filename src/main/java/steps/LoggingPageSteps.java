package steps;

import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.TopMenuPage;

public class LoggingPageSteps {
    private final TopMenuPage topMenuPage = new TopMenuPage();
    private final LoginPage loginPage = new LoginPage();

    @When("user clicks on Sign In button from Top Menu")
    public void clickSignInButton() {
        topMenuPage.clickElement(topMenuPage.getAccountButton());
    }

    @When("user enters valid credentials into login and password inputs")
    public void enterValidCredentials() {
        loginPage.enterValidCredentials();
    }

    @When("user clicks on Sign In button")
    public void clickOnSignInButton() {
        loginPage.clickElement(loginPage.getSignInButton());
    }
}
