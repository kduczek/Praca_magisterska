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

    @When("user changes pagination to {string}")
    public void changePagination(String value) throws InterruptedException {
        searchResultsPage.selectFromDropdownByValue(searchResultsPage.getPaginationDropdown(), value);
        searchResultsPage.waitForPageToLoad();
    }
}