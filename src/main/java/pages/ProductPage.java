package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    private final String sizeButton = "//div[@option-label='[SIZE]']";
    private final String colorButton = "//div[@aria-label='[COLOR]']";
    private final By quantityInput = By.xpath("//input[@name='qty']");
    private final By addToCartButton = By.xpath("//button[@title='Add to Cart']");
    private final By requiredFieldError = By.xpath("//div[@class='mage-error']");
    private final By quantityError = By.xpath("//div[@id='qty-error']");
    private final By addedToCartMessage = By.xpath("//div[@class='messages']");

    public By getSizeButton(String size) {
        return By.xpath(sizeButton.replace("[SIZE]", size));
    }

    public By getColorButton(String colorName) {
        return By.xpath(colorButton.replace("[COLOR]", colorName));
    }

    public By getQuantityInput() {
        return quantityInput;
    }

    public By getAddToCartButton() {
        return addToCartButton;
    }

    public By getRequiredFieldError() {
        return requiredFieldError;
    }

    public By getQuantityError() {
        return quantityError;
    }

    public By getAddedToCartMessage() {
        return addedToCartMessage;
    }
}
