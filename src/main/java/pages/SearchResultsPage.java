package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {
    private final By numberOfElements = By.xpath("//p[@class='toolbar-amount']");
    private final By noResultsFoundWarning = By.xpath("//div[normalize-space(.)='Your search returned no results.']");
    private final By productContainer = By.xpath("//span[@class='product-image-container']");
    private final By paginationDropdown = By.xpath("//div[contains(@class, 'limiter')]//select[@id='limiter']");
    private final By paginationOption = By.xpath("//option[@value='24']");

    public By getNumberOfElements() {
        return numberOfElements;
    }

    public By getNoResultsFoundWarning() {
        return noResultsFoundWarning;
    }

    public By getProductContainer() {
        return productContainer;
    }

    public By getPaginationDropdown() {
        return paginationDropdown;
    }

    public By getPaginationOption() {
        return paginationOption;
    }
}