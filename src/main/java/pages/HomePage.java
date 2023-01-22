package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By signedOutMessage = By.xpath("//span[normalize-space(.)='You are signed out']");
    private final By shopNewYogaButton = By.xpath("//span[normalize-space(.)='Shop New Yoga']");

    public By getSignedOutMessage() {
        return signedOutMessage;
    }

    public By getShopNewYogaButton() {
        return shopNewYogaButton;
    }
}
