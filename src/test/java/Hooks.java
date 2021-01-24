import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "json:target/html-reports/cucumber.json",
                "html:target/html-reports/cucumber" },
        tags = "@tags",
        glue = "steps",
        features = "src/resources/features"
)

public class Hooks {
}
