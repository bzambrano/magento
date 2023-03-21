package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packageco.com.demo.magento.ui
 */
public class PaginaFormularioInscripcion extends PageObject {

    public static final Target INPUT_FIRST_NAME = Target.the(
            "input firstName").located(By.cssSelector("#firstname"));


    public static final Target INPUT_LAST_NAME = Target.the(
            "input lastName").located(By.cssSelector("#lastname"));


    public static final Target CHEK_BOX_IS_SUBSCRIBED = Target.the(
            "chekBox is Subscribed").located(By.cssSelector("#is_subscribed"));


    public static final Target INPUT_EMAIL = Target.the(
            "input email").located(By.cssSelector("#email_address"));


    public static final Target INPUT_PASSWORD = Target.the(
            "the field password").located(By.cssSelector("#password[title='Password']"));


    public static final Target INPUT_PASSWORD_CONFIRMATION = Target.the(
            "input password Confirmation").located(By.cssSelector("#password-confirmation"));


    public static final Target BTN_CREATE_ACCOUNT = Target.the(
            "button create account").located(By.cssSelector("button[title='Create an Account']"));

    public static final Target ALERT_FIELD_INPUT_FIRST_NAME = Target.the(
            "Field Alert firstName").located(By.cssSelector("#firstname+div"));

    public static final Target ALERT_FIELD_INPUT_LAST_NAME = Target.the(
            "Field Alert  lastName").located(By.cssSelector("#lastname+div"));

    public static final Target ALERT_FIELD_INPUT_EMAIL = Target.the(
            "Field Alert  email")
            .located(By.cssSelector("#email_address+div"));

    public static final Target ALERT_FIELD_INPUT_PASSWORD = Target.the(
            "Field Alert password")
            .located(By.cssSelector("#password[title='Password']+div"));

    public static final Target ALERT_FIELD_INPUT_PASSWORD_CONFIRMATION = Target.the(
            "Field Alert  password Confirmation").located(By.cssSelector("#password-confirmation+div"));


}
