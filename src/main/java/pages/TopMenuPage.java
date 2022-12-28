package pages;

import org.openqa.selenium.By;

public class TopMenuPage extends BasePage {
    private final By accountButton = By.xpath("//li[@class='authorization-link']/a");
    private final By greetingsSpan = By.xpath("//span[@class='logged-in']");

    public By getAccountButton() {
        return accountButton;
    }

    public By getGreetingsSpan() {
        return greetingsSpan;
    }
}
