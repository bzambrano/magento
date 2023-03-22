package runners.ui;

/**
 * file packagerunners.ui
 */

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"com/magento/definitions",
                "com/magento/hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@ProceedCheckout")
public class TestRunnerProceedCheckout {
}
