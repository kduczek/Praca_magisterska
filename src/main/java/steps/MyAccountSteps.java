package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.MyAccountPage;

public class MyAccountSteps {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Then("user should be moved to My Account page")
    public void verifyIfUserWasMovedToMyAccount() {
        Assert.assertTrue(myAccountPage.isElementVisible(myAccountPage.getMyAccountHeader()), "User wasn't moved to My Account");
    }

    @Then("Newsletter status should be equal to {string}")
    public void verifyNewsletterStatus(String expectedMessage) {
        Assert.assertEquals(myAccountPage.getText(myAccountPage.getSubscriptionMessage()), expectedMessage, "Wrong subscription message");
    }
}