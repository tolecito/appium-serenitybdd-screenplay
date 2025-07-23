package org.automation.appium.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.automation.appium",
        plugin = {"pretty", "summary", "html:target/cucumber-reports.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class MobileTestRunner {}


