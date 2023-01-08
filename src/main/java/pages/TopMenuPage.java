package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TopMenuPage extends BasePage {
    private final By accountButton = By.xpath("//li[@class='authorization-link']/a");
    private final By greetingsSpan = By.xpath("//span[@class='logged-in']");
    private final By defaultGreetingsSpan = By.xpath("//span[@class='not-logged-in']");
    private final By searchInput = By.xpath("//input[@id='search']");

    //SHOPPING CART
    private final By shoppingCartIcon = By.xpath("//a[contains(@class, 'showcart')]");
    private final By shoppingCartCounter = By.xpath("//a[contains(@class, 'showcart')]//span[@class='counter-number']");
    private final By shoppingCartDeleteIcon = By.xpath("//a[@title='Remove item']");
    private final By cancelDeletingFromCart = By.xpath("//button[normalize-space(.)='Cancel']");
    private final By allowDeletingFromCart = By.xpath("//button[normalize-space(.)='OK']");
    private final By emptyCartMessage = By.xpath("//strong[@class='subtitle empty']");

    //GREETINGS MESSAGE DROPDOWN
    private final By customerMenuArrow = By.xpath("//button[@data-action='customer-menu-toggle']");
    private final By signOutButton = By.xpath("//a[normalize-space(.)='Sign Out']");

    public By getAccountButton() {
        return accountButton;
    }

    public By getGreetingsSpan() {
        return greetingsSpan;
    }

    public By getDefaultGreetingsSpan() {
        return defaultGreetingsSpan;
    }

    public By getSignOutButton() {
        return signOutButton;
    }

    public By getCustomerMenuArrow() {
        return customerMenuArrow;
    }

    public void searchForItem(String item) {
        clearInput(searchInput);
        inputValue(searchInput, item);
        sendKey(searchInput, Keys.ENTER);
    }

    public By getShoppingCartIcon() {
        return shoppingCartIcon;
    }

    public By getShoppingCartCounter() {
        return shoppingCartCounter;
    }

    public By getShoppingCartDeleteIcon() {
        return shoppingCartDeleteIcon;
    }

    public By getCancelDeletingFromCart() {
        return cancelDeletingFromCart;
    }

    public By getAllowDeletingFromCart() {
        return allowDeletingFromCart;
    }

    public By getEmptyCartMessage() {
        return emptyCartMessage;
    }
}
