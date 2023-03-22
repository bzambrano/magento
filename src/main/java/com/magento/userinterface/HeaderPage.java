package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packageco.com.demo.magento.ui
 */
public class HeaderPage extends PageObject {

    public static final Target ANCHOR_SIGN_IN = Target.the(
                    "button sing in ")
            .located(By.xpath("(//a[contains(text(),'Sign In ')])[1]"));

    public static final Target BTN_DROPDOWN  = Target.the(
                    "button dropdown ")
            .located(By.cssSelector("div.panel.wrapper span[role='button']"));

    public static final Target BTN_SIGN_OUT = Target.the(
                    "button sing out")
            .located(By.xpath("(//a[contains(text(),'Sign Out ')])[1]"));

    public static final Target BTN_CARRO_COMPRAS = Target.the(
                    "Botón del carro de compras")
            .located(By.cssSelector("div.header a.showcart"));

}
