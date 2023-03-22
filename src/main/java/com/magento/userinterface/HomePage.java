package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packageco.com.demo.magento.ui
 */
public class HomePage extends PageObject {

    public static final Target MENU_BAR = Target.the(
                    "home page menu bar ")
            .located(By.cssSelector("#ui-id-2"));

    public static final Target GRAPHIC_CONTENT  = Target.the(
                    "home page graphic content")
            .located(By.cssSelector("#maincontent"));

    public static final Target MESSAGE_ERROR_LOGIN  = Target.the(
                    "home page message error login")
            .located(By.cssSelector("#maincontent"));

    public static final Target BARRA_MENU_WOMEN   = Target.the(
                    "barra de menu opcion Women")
            .locatedBy("//span[contains(text(),'Women')]//ancestor::a");


    public static final Target BARRA_MENU_MEN   = Target.the(
                    "barra de menu opcion Men")
            .locatedBy("//span[contains(text(),'Men')]//ancestor::a");




}
