package runners.ui;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

/**
 * file packagerunners.ui
 */
@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"co/com/demo/magento/stepsDefinitions",
                "co/com/demo/magento/hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
tags = "@WebApp"
)
public class TestsRunnerCreateAccount {

}
