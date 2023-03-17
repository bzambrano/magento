package runners.ui;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

/**
 * file packagerunners.ui
 */
@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"com/magento/stepsDefinitions",
                "com/magento/hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Login"
)
public class TestsRunnerLogin {
}
