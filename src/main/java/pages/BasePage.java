package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static pages.DriverProvider.getDriver;

public class BasePage {

    public void clickElement(By element) {
        getDriver().findElement(element).click();
    }

    public void clickElementJS(By element) {
        WebElement webElement = getDriver().findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void inputValue(By element, String value) {
        getDriver().findElement(element).sendKeys(value);
    }

    public void clearInput(By element) {
        getDriver().findElement(element).clear();
    }

    public void sendKey(By element, Keys key) {
        getDriver().findElement(element).sendKeys(key);
    }

    public void scrollElementIntoView(By element) throws InterruptedException {
        WebElement webElement = getDriver().findElement(element);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        Thread.sleep(500);
    }

    public void scrollToTheBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

    public void selectFromDropdownByValue(By element, String value) throws InterruptedException {
        scrollElementIntoView(element);
        Select dropdown = new Select(getDriver().findElement(element));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByVisibleText(By element, String value) throws InterruptedException {
        scrollElementIntoView(element);
        Select dropdown = new Select(getDriver().findElement(element));
        dropdown.selectByVisibleText(value);
    }

    public int getCountOfElements(By elements) {
        return getDriver().findElements(elements).size();
    }

    public boolean isElementVisible(By element) {
        try {
            return getDriver().findElement(element).isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }

    public String getText(By element) {
        waitForElementIsVisible(element, 5, 500);
        String result = getDriver().findElement(element).getText();
        return result.trim();
    }

    public String getAttribute(By element, String attribute) {
        return getDriver().findElement(element).getAttribute(attribute);
    }

    public void waitForElementIsVisible(By element, int time, int interval) {
        WebDriverWait waitDriver = new WebDriverWait(getDriver(), Duration.ofSeconds(time), Duration.ofMillis(interval));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementToBeClickable(By element, int time, int interval) {
        WebDriverWait waitDriver = new WebDriverWait(getDriver(), Duration.ofSeconds(time), Duration.ofMillis(interval));
        waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void reloadPage() {
        getDriver().navigate().refresh();
    }

    public void waitForPageToLoad() {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void waitUntilTextEquals(By element, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    if (!getText(element).equals(text))
                        return true;
                    else
                        return false;
                } catch (StaleElementReferenceException e) {
                    if (!getText(element).equals(text))
                        return true;
                    else
                        return false;
                }
            }
        });
    }

    public List<String> getTextFromAllItems(List<WebElement> elements) {
        List<String> result = new ArrayList<>();

        for(WebElement singleElement : elements) {
            result.add(singleElement.getText());
        }

        return result;
    }
}
