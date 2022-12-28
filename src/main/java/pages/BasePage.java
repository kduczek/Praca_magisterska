package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static pages.DriverProvider.getDriver;

public class BasePage {

    public void clickElement(By element) {
        getDriver().findElement(element).click();
    }

    public void inputValue(By element, String value) {
        getDriver().findElement(element).sendKeys(value);
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

    public void waitForElementIsVisible(By element, int time, int interval) {
        WebDriverWait waitDriver = new WebDriverWait(getDriver(), Duration.ofSeconds(time), Duration.ofMillis(interval));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(element));
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
}
