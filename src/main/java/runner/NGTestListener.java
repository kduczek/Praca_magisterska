package runner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import pages.DriverProvider;

public class NGTestListener implements ITestListener {
//    BasePage basePage = new BasePage();

    @Override
    public void onStart(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "/Users/krystian/Desktop/Praca_magisterska/chromedriver");
        new DriverProvider();
    }
}