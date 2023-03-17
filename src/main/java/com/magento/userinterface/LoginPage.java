package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packagecom.magento.ui
 */
public class LoginPage extends PageObject {


    public static final Target INPUT_EMAIL = Target.the(
                    "The email field ")
            .located(By.cssSelector("#email"));

    public static final Target INPUT_PASSWORD = Target.the(
                    "The password field ")
            .located(By.cssSelector("#pass"));

    public static final Target BTN_SIGN_IN = Target.the(
                    "The button sign in ")
            .located(By.cssSelector("#send2"));
}
