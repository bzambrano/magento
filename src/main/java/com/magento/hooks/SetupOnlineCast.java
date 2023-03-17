package com.magento.hooks;

import com.magento.helpers.ToRemember;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * This class contains a Cucumber hook that sets up environment variables for the online cast
 * of the Magento demo application. It retrieves the base URL and registration URL from the
 * system environment variables and saves them as memory variables for the actor in the spotlight.
 * The memory variables are then used by the screenplay pattern to interact with the application.
 */
public class SetupOnlineCast {

    private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String URL_BASE = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url.base");
    private final String URL_REGISTER = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url.register");

    private final String EMAIL_USER = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("user.email");
    private final String PASSWORD_USER = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("user.password");


    /**
     * Sets up the environment variables for the online cast of the Magento demo application. Retrieves
     * the base URL and registration URL from the system environment variables and saves them as memory
     * variables for the actor in the spotlight. The memory variables are then used by the screenplay
     * pattern to interact with the application.
     */
    @Before("@WebApp")
    public void setupEnvironmentVariables() {
        theActorInTheSpotlight().remember(ToRemember.URL_BASE.name(), URL_BASE);
        theActorInTheSpotlight().remember(ToRemember.URL_REGISTER.name(), URL_REGISTER);

        theActorInTheSpotlight().remember(ToRemember.USER_EMAIL.name(), EMAIL_USER);
        theActorInTheSpotlight().remember(ToRemember.USER_PASSWORD.name(), PASSWORD_USER);
    }

    @After("@WebApp")
    public void closed (){
        Serenity.getDriver().quit();
    }

}
