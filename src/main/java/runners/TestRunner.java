package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = {"src/test/resources/features"},
        glue = {"steps"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}