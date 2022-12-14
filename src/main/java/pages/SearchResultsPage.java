package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultsPage extends BasePage {
    private final By numberOfElements = By.xpath("//p[@class='toolbar-amount']");
    private final By noResultsFoundWarning = By.xpath("//div[normalize-space(.)='Your search returned no results.']");
    private final By productContainer = By.xpath("//span[@class='product-image-container']");
    private final String productLinkByName = "//strong[contains(@class, 'product-item-name')]//a[normalize-space(.)='[NAME]']";
    private final By sortByDropdown = By.xpath("//select[@id='sorter']");
    private final By productName = By.xpath("//a[@class='product-item-link']");
    private final By productPrice = By.xpath("//span[@data-price-type='finalPrice']");
    private final By sortingOrderSwitch = By.xpath("//a[@data-role='direction-switcher']");
    private final By relatedSearchTerms = By.xpath("//dl/dt[normalize-space(.)='Related search terms']/../dd");

    //PAGINATION
    private final By paginationDropdown = By.xpath("//select[@id='limiter']");
    private final String paginationOption = "//option[@value='[VALUE]']";
    private final String pageLink = "//ul[contains(@class, 'pages-items')]//a//span[normalize-space(.)='[PAGE_NUMBER]']";
    private final By previousPageArrow = By.xpath("//a[@title='Previous']");
    private final By nextPageArrow = By.xpath("//a[@title='Next']");
    private final By currentPageNumber = By.xpath("//span[contains(text(), 'currently reading page')]/following-sibling::span");

    //DISPLAY STYLE
    private final By selectedList = By.xpath("//strong[@title='List']");
    private final By selectedGrid = By.xpath("//strong[@title='Grid']");
    private final By notSelectedList = By.xpath("//a[@title='List']");
    private final By notSelectedGrid = By.xpath("//a[@title='Grid']");

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

    public By getSortByDropdown() {
        return sortByDropdown;
    }

    public By getSortingOrderSwitch() {
        return sortingOrderSwitch;
    }

    public By getSelectedList() {
        return selectedList;
    }

    public By getSelectedGrid() {
        return selectedGrid;
    }

    public boolean areElementsSortedByName(String order) {
        List<WebElement> elements = DriverProvider.getDriver().findElements(productName);
        List<String> productNames = getTextFromAllItems(elements);

        List<String> sortedList = new ArrayList<>(productNames);
        Collections.sort(productNames);
        if(order.equals("descending"))
            Collections.reverse(sortedList);

        return sortedList.equals(productNames);
    }

    public boolean areElementsSortedByPrice(String order) {
        List<WebElement> elements = DriverProvider.getDriver().findElements(productPrice);
        List<Double> prices = new ArrayList<>();

        for(WebElement singleElement : elements) {
            String temp = singleElement.getText();
            temp = temp.substring(1);
            prices.add(Double.valueOf(temp));
        }

        List<Double> sortedList = new ArrayList<>(prices);
        Collections.sort(prices);
        if(order.equals("descending"))
            Collections.reverse(sortedList);
        
        return sortedList.equals(prices);
    }

    public void selectDisplayingStyle(String styleName) {
        if (styleName.equalsIgnoreCase("list"))
            clickElement(notSelectedList);
        else
            clickElement(notSelectedGrid);
    }

    public void verifyRelatedSearchTerms(String keyword) {
        List<WebElement> elements = DriverProvider.getDriver().findElements(relatedSearchTerms);
        List<String> relatedSearchTermsList = getTextFromAllItems(elements);

        for(String singleSearchTerm : relatedSearchTermsList) {
            Assert.assertTrue(singleSearchTerm.toLowerCase().contains(keyword.toLowerCase()), "Related Search Term " + singleSearchTerm + " doesn't contained keyword");
        }
    }
}