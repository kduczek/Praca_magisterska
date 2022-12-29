package pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {
    private final By cartIcon = By.xpath("//div[@class='minicart-wrapper']//a");

    public By getCartIcon() {
        return cartIcon;
    }
}
