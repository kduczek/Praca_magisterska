package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchResultsPage;

public class SearchResultsSteps {
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Then("search results indicator should be equal to {string}")
    public void verifyCountOfSearchResults(String expectedResult) {
        Assert.assertEquals(searchResultsPage.getText(searchResultsPage.getNumberOfElements()),
                expectedResult,
                "Wrong count of Search Results");
    }

    @Then("\"Your search returned no results.\" warning message should be visible")
    public void verifyVisibilityOfNoResultsFoundWarning() {
        Assert.assertTrue(searchResultsPage.isElementVisible(searchResultsPage.getNoResultsFoundWarning()), "Warning wasn't visible");
    }

    @Then("number of elements on page should be equal to {int}")
    public void verifyNumberOfElementsOnPage(int expectedNumber) {
        Assert.assertEquals(searchResultsPage.getCountOfElements(searchResultsPage.getProductContainer()), expectedNumber, "Number of elements doesn't match");
    }

    @When("user changes pagination to {int}")
    public void changePagination(int value) throws InterruptedException {
        searchResultsPage.selectFromDropdownByVisibleText(searchResultsPage.getPaginationDropdown(), String.valueOf(value));
        searchResultsPage.waitForPageToLoad();
    }

    @When("user goes to {int} st/nd/rd/th page")
    public void goToPage(int pageNumber) {
        searchResultsPage.clickElementJS(searchResultsPage.getPageLink(pageNumber));
    }

    @When("user clicks next page arrow")
    public void clickNextPageArrow() {
        searchResultsPage.clickElementJS(searchResultsPage.getNextPageArrow());
        searchResultsPage.waitForPageToLoad();
    }

    @When("user clicks previous page arrow")
    public void clickPreviousPageArrow() {
        searchResultsPage.clickElementJS(searchResultsPage.getPreviousPageArrow());
        searchResultsPage.waitForPageToLoad();
    }

    @When("user clicks on {int} page link number")
    public void clickPageNumber(int pageNumber) {
        searchResultsPage.clickElement(searchResultsPage.getPageLink(pageNumber));
    }

    @Then("current page should be equal to {int}")
    public void verifyCurrentPageNumber(int expectedNumber) {
        Assert.assertEquals(searchResultsPage.getAttribute(searchResultsPage.getCurrentPageNumber(), "innerHTML"),
                String.valueOf(expectedNumber),
                "Wrong current page");
    }

    @When("user clicks on {string} product link")
    public void clickProductLink(String productName) {
        searchResultsPage.clickElement(searchResultsPage.getProductLinkByName(productName));
    }

    @When("user sorts by {string}")
    public void sortBy(String sort) throws InterruptedException {
        searchResultsPage.selectFromDropdownByVisibleText(searchResultsPage.getSortByDropdown(), sort);
    }

    @Then("product names should be sorted in {string} order")
    public void verifySortingResults(String order) {
        Assert.assertTrue(searchResultsPage.areElementsSortedByName(order), "Wrong sorting order");
    }

    @When("user changes sorting order")
    public void changeSortingOrder() {
        searchResultsPage.clickElementJS(searchResultsPage.getSortingOrderSwitch());
    }
}