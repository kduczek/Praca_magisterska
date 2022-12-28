package steps;

import io.cucumber.java.en.When;
import pages.BasePage;

public class SharedSteps {
    private final BasePage basePage = new BasePage();

    @When("user waits {int} seconds")
    public void waitSeconds(int duration) throws InterruptedException {
        Thread.sleep(1000L * duration);
    }
}
