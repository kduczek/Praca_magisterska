package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By signedOutMessage = By.xpath("//span[normalize-space(.)='You are signed out']");

    public final By getSignedOutMessage() {
        return signedOutMessage;
    }
}
