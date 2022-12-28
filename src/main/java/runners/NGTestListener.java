package runners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import pages.DriverProvider;

import static pages.DriverProvider.closeDriver;

public class NGTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "/Users/krystian/Desktop/Praca_magisterska/chromedriver");
        new DriverProvider();
    }

    @Override
    public void onFinish(ITestContext context) {
        closeDriver();
    }
}