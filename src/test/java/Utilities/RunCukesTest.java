package Utilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = "StepDefinitions",
        tags = "@RUN",
        plugin = "pretty",
        monochrome = true,
        dryRun = false,
        publish = true
)
public class RunCukesTest {
    //This class remains blank
}
