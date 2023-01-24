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

    @Then("validation messages for all inputs in Create Account should be {string}")
    public void verifyCreateAccountInputs(String visibility) {
        createAccountPage.verifyVisibilityOfValidationForAllInputs(visibility.equals("visible"));
    }

    @Then("confirm password validation should be visible with text {string}")
    public void verifyValidationOfConfirmPassword(String validationMessage) {
        Assert.assertEquals(createAccountPage.getText(createAccountPage.getConfirmPasswordValidation()), validationMessage, "Wrong validation message");
    }

    @Then("Password Strength should be {string}")
    public void verifyPasswordStrength(String expectedStrength) {
        String actualStrength = createAccountPage.getText(createAccountPage.getPasswordStrengthMeter()).replace("Password Strength: ", "");
        Assert.assertEquals(actualStrength, expectedStrength, "Wrong Password Strength message");
    }
}