package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private static final By emailInput = By.xpath("//input[@name='login[username]']");
    private static final By passwordInput = By.xpath("//input[@name='login[password]']");
    private static final By signInButton = By.xpath("//button[@type='submit' and @name='send']");
    private static final By emailRequiredMessage = By.xpath("//div[@id='email-error']");
    private static final By emailInputValidation = By.xpath("//input[@aria-invalid='true' and @id='email']");
    private static final By passwordRequiredMessage = By.xpath("//div[@id='pass-error']");
    private static final By passwordInputValidation = By.xpath("//input[@aria-invalid='true' and @id='pass']");

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

    public void verifyEmptyEmailValidation() {
        Assert.assertTrue(isElementVisible(emailInputValidation), "Email input doesn't had red border");
        Assert.assertTrue(isElementVisible(emailRequiredMessage), "Empty email validation message wasn't visible");
    }

    public void verifyEmptyPasswordValidation() {
        Assert.assertTrue(isElementVisible(passwordInputValidation), "Password input doesn't had red border");
        Assert.assertTrue(isElementVisible(passwordRequiredMessage), "Empty password validation message wasn't visible");
    }
}
