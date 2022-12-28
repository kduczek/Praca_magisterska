package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static final By emailInput = By.xpath("//input[@name='login[username]']");
    private static final By passwordInput = By.xpath("//input[@name='login[password]']");
    private static final By signInButton = By.xpath("//button[@type='submit' and @name='send']");

    public By getEmailInput() {
        return emailInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public By getSignInButton() {
        return signInButton;
    }

    public void enterValidCredentials() {
        inputValue(emailInput, "juiceshop357@gmail.com");
        inputValue(passwordInput, "Start123@");
    }
}
