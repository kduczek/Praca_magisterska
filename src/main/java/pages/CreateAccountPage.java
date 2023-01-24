package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Map;
import java.util.Random;

public class CreateAccountPage extends BasePage {
    private final By createAnAccountButton = By.xpath("//span[normalize-space()='Create an Account']");
    private final By firstNameInput = By.xpath("//input[@id='firstname']");
    private final By lastNameInput = By.xpath("//input[@id='lastname']");
    private final By emailNameInput = By.xpath("//input[@id='email_address']");
    private final By passwordNameInput = By.xpath("//input[@id='password']");
    private final By confirmPasswordNameInput = By.xpath("//input[@id='password-confirmation']");
    private final By subscriptionCheckbox = By.xpath("//input[@id='is_subscribed']");

    //VALIDATION
    private final By firstNameValidation = By.xpath("//div[@id='firstname-error']");
    private final By lastNameValidation = By.xpath("//div[@id='lastname-error']");
    private final By emailValidation = By.xpath("//div[@id='email_address-error']");
    private final By passwordValidation = By.xpath("//div[@id='password-error']");
    private final By confirmPasswordValidation = By.xpath("//div[@id='password-confirmation-error']");
    private final By passwordStrengthMeter = By.xpath("//div[@id='password-strength-meter']");

    public By getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public final By getFirstNameInput() {
        return firstNameInput;
    }

    public By getLastNameInput() {
        return lastNameInput;
    }

    public By getEmailNameInput() {
        return emailNameInput;
    }

    public By getPasswordNameInput() {
        return passwordNameInput;
    }

    public By getConfirmPasswordNameInput() {
        return confirmPasswordNameInput;
    }

    public By getPasswordValidation() {
        return passwordValidation;
    }

    public By getConfirmPasswordValidation() {
        return confirmPasswordValidation;
    }

    public By getPasswordStrengthMeter() {
        return passwordStrengthMeter;
    }

    public By getSubscriptionCheckbox() {
        return subscriptionCheckbox;
    }

    public void createUser(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMaps().get(0);

        if (credentials.get("First Name") != null)
            inputValue(firstNameInput, credentials.get("First Name"));
        if (credentials.get("Last Name") != null)
            inputValue(lastNameInput, credentials.get("Last Name"));
        if (credentials.get("Email") != null) {
            if (credentials.get("Email").equals("[RANDOM]")) {
                Random r = new Random();
                StringBuilder email = new StringBuilder();
                for (int i = 0; i < 10; i++)
                    email.append((char) (r.nextInt(26) + 'a'));
                email.append("@test.pl");
                inputValue(emailNameInput, email.toString());
            } else {
                inputValue(emailNameInput, credentials.get("Email"));
            }
        }
        if (credentials.get("Password") != null) {
            clearInput(passwordNameInput);
            inputValue(passwordNameInput, credentials.get("Password").replaceAll("\\[SPACE\\]", " "));
        }
        if (credentials.get("Confirm Password") != null)
            inputValue(confirmPasswordNameInput, credentials.get("Confirm Password"));
    }

    public void verifyVisibilityOfValidationForAllInputs(boolean visible) {
        if (visible) {
            Assert.assertTrue(isElementVisible(firstNameValidation) &&
                            isElementVisible(lastNameValidation) &&
                            isElementVisible(emailValidation) &&
                            isElementVisible(passwordValidation) &&
                            isElementVisible(confirmPasswordValidation),
                    "Validation messages weren't visible");
        } else {
            Assert.assertFalse(isElementVisible(firstNameValidation) &&
                            isElementVisible(lastNameValidation) &&
                            isElementVisible(emailValidation) &&
                            isElementVisible(passwordValidation) &&
                            isElementVisible(confirmPasswordValidation),
                    "Validation messages were visible");
        }
    }
}