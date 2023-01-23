package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.TopMenuPage;

public class CreateAccountSteps {
    TopMenuPage topMenuPage = new TopMenuPage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @When("user clicks Create an Account button from Top Menu")
    public void clickCreateAnAccountButtonFromTopMenu() {
        topMenuPage.clickElement(topMenuPage.getCreateAccountButton());
    }

    @When("user clicks Create an Account button")
    public void clickCreateAnAccountButton() {
        createAccountPage.clickElement(createAccountPage.getCreateAnAccountButton());
    }

    @When("user inputs following details for new user")
    public void fillDetails(DataTable dataTable) {
        createAccountPage.createUser(dataTable);
    }

    @Then("confirmation message after registering new account should be visible")
    public void verifyIfConfirmationMessageIsVisible() {
        Assert.assertTrue(createAccountPage.isElementVisible(createAccountPage.getRegistrationConfirmMessage()), "Message wasn't visible");
    }
}