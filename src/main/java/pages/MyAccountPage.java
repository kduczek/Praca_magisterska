package pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage{
    private final By myAccountHeader = By.xpath("//span[@data-ui-id='page-title-wrapper' and normalize-space(.)='My Account']");
    private final By subscriptionMessage = By.xpath("//div[contains(@class, 'box-newsletter')]//p");
    private final By registrationConfirmMessage = By.xpath("//div[@class='messages']//div[contains(text(), 'Thank you for registering')]");

    public By getMyAccountHeader() {
        return myAccountHeader;
    }

    public By getSubscriptionMessage() {
        return subscriptionMessage;
    }

    public By getRegistrationConfirmMessage() {
        return registrationConfirmMessage;
    }
}