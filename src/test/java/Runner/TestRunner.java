package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\java\\Features\\Adactin.feature"},
        glue = {"Step","Hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@SmokeTest",
       plugin = {"pretty", "html:target/cucumber.html",  // Reports
        "json:target/cucumber.json", "junit:target/cucumber.xml"}
)
public class TestRunner {
    }

