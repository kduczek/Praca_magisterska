package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@krystian",
        features = {"src/test/resources/features"},
        glue = {"steps"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}