package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
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
        Assert.assertTrue(searchResultsPage.areElementsSortedByName(order), "Wrong Name sorting order");
    }

    @Then("prices should be sorted in {string} order")
    public void verifyPriceSortingResults(String order) {
        Assert.assertTrue(searchResultsPage.areElementsSortedByPrice(order), "Wrong Price sorting order");
    }

    @When("user changes sorting order")
    public void changeSortingOrder() {
        searchResultsPage.clickElementJS(searchResultsPage.getSortingOrderSwitch());
    }

    @When("user changes displaying style to {string}")
    public void changeDisplayingStyle(String styleName) {
        searchResultsPage.selectDisplayingStyle(styleName);
    }

    @Then("displaying style should be set to List")
    public void verifyIfDisplayingStyleIsSetToList() {
        Assert.assertTrue(searchResultsPage.isElementVisible(searchResultsPage.getSelectedList()), "Displaying style wasn't set to List");
    }

    @Then("displaying style should be set to Grid")
    public void verifyIfDisplayingStyleIsSetToGrid() {
        Assert.assertTrue(searchResultsPage.isElementVisible(searchResultsPage.getSelectedGrid()), "Displaying style wasn't set to Grid");
    }

    @Then("all Related Search Terms should contain {string} word")
    public void verifyRelatedSearchTerms(String keyword) {
        searchResultsPage.verifyRelatedSearchTerms(keyword);
    }

    @When("user expands shopping option named {string}")
    public void expandShoppingOption(String option) {
        searchResultsPage.clickElement(searchResultsPage.getShoppingOption(option));
    }

    @When("user selects price filter option with following starting price {string}")
    public void clickPriceFilter(String startingPrice) {
        searchResultsPage.clickElement(searchResultsPage.getPriceOption(startingPrice));
    }

    @When("user selects filter option named {string}")
    public void clickFilterByName(String filterName) {
        searchResultsPage.clickElement(searchResultsPage.getGeneralFilterOption(filterName));
    }

    @Then("all products prices should be between {double} and {double}")
    public void verifyProductsPriceRange(double startingPrice, double endPrice) {
        Assert.assertTrue(searchResultsPage.verifyPricesRange(startingPrice, endPrice), "Wrong sorting by Price");
    }

    @Then("all active filters should be equal to following")
    public void verifyActiveFilters(DataTable dataTable) {
        searchResultsPage.verifyAllActiveFilters(dataTable);
    }

    @Then("Clear All filters button should be visible")
    public void verifyIfClearAllButtonIsVisible() {
        Assert.assertTrue(searchResultsPage.isElementVisible(searchResultsPage.getClearAllFiltersButton()), "Clear All wasn't visible");
    }

    @Then("Clear All filters button should not be visible")
    public void verifyIfClearAllButtonIsInvisible() {
        Assert.assertFalse(searchResultsPage.isElementVisible(searchResultsPage.getClearAllFiltersButton()), "Clear All was visible");
    }

    @When("user clicks Clear All filters button")
    public void clickClearAllButton() {
        searchResultsPage.clickElement(searchResultsPage.getClearAllFiltersButton());
    }
}