package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {
    private final By numberOfElements = By.xpath("//p[@class='toolbar-amount']");
    private final By noResultsFoundWarning = By.xpath("//div[normalize-space(.)='Your search returned no results.']");

    public By getNumberOfElements() {
        return numberOfElements;
    }

    public By getNoResultsFoundWarning() {
        return noResultsFoundWarning;
    }
}