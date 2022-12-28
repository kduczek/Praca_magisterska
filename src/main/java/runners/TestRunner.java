package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = {"src/test/resources/features/Logging.feature"},
        glue = {"steps"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}