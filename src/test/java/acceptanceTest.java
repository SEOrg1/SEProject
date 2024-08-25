
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(features ="mtFeatures",
    plugin = {"html:target/cucmber/wikipedia.html"},
            monochrome = true,
            snippets = CucumberOptions.SnippetType.CAMELCASE,
            glue = {"Steps"}
    )

    public class acceptanceTest {
}
