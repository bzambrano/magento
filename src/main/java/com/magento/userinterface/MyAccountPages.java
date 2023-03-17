package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packageco.com.demo.magento.ui
 */
public class MyAccountPages extends PageObject {

    public static final Target SPAN_TITLE = Target.the(
            "title in the My Account section ")
            .located(By.cssSelector("span[data-ui-id='page-title-wrapper']"));

    public static final Target CONTACT_INFORMATION = Target.the(
                    "Contact Information section")
            .located(By.cssSelector("div.box-information  p"));

    public static final Target  WELCOME_MESSAGE_HEADER  = Target.the(
            "welcome message in header ")
            .located(By.cssSelector("div[id='store.links'] span.logged-in"));


    public static final Target  MESSAGE_SUCCESS  = Target.the(
            "message success")
            .located(By.cssSelector("div[data-ui-id='message-success'] div"));

}
