package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {
    private final By numberOfElements = By.xpath("//p[@class='toolbar-amount']");
    private final By noResultsFoundWarning = By.xpath("//div[normalize-space(.)='Your search returned no results.']");
    private final By productContainer = By.xpath("//span[@class='product-image-container']");
    private final By paginationDropdown = By.xpath("//div[contains(@class, 'limiter')]//select[@id='limiter']");
    private final String paginationOption = "//option[@value='[VALUE]']";
    private final String pageLink = "//ul[contains(@class, 'pages-items')]//a//span[normalize-space(.)='[PAGE_NUMBER]']";
    private final By previousPageArrow = By.xpath("//a[@title='Previous']");
    private final By nextPageArrow = By.xpath("//a[@title='Next']");
    private final By currentPageNumber = By.xpath("//span[contains(text(), 'currently reading page')]/following-sibling::span");
    private final String productLinkByName = "//strong[contains(@class, 'product-item-name')]//a[normalize-space(.)='[NAME]']";


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

    public By getPaginationOption(int value) {
        return By.xpath(paginationOption.replace("[VALUE]", String.valueOf(value)));
    }

    public By getPageLink(int pageNumber) {
        return By.xpath(pageLink.replace("[PAGE_NUMBER]", String.valueOf(pageNumber)));
    }

    public By getPreviousPageArrow() {
        return previousPageArrow;
    }

    public By getNextPageArrow() {
        return nextPageArrow;
    }

    public By getCurrentPageNumber() {
        return currentPageNumber;
    }

    public By getProductLinkByName(String name) {
        return By.xpath(productLinkByName.replace("[NAME]", name));
    }
}