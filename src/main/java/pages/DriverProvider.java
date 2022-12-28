package pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverProvider {
    private static WebDriver driver = null;
    private static final long PAGE_LOAD = 10;
    private static final long IMPLICIT_WAIT = 5;
    private static final long HEIGHT = 1080;
    private static final long WIDTH = 1920;

    public DriverProvider() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=" + WIDTH + "x" + HEIGHT);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}