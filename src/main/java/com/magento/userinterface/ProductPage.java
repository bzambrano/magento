package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packagecom.magento.userinterface
 */
public class ProductPage extends PageObject  {

    public static final Target SIZE_ANY = Target.the(
                    "the size ")
            .located(By.xpath("(//div[@class='swatch-option text'])[1]"));

    public static final Target COLOR_ANY = Target.the(
                    "the color ")
            .located(By.xpath("(//div[@class='swatch-option color'])[1]"));

    public static final Target BTN_ADD_TO_CART = Target.the(
                    "the button add to cart ")
            .located(By.cssSelector("#product-addtocart-button"));

    public static final Target MESSAGE_SUSSES = Target.the(
                    "the message susses ")
            .located(By.cssSelector("div[data-ui-id='message-success'] div"));

    public static final Target BTN_PERSONALIZAR_AGREGAR_CARRITO = Target.the(
                    "the message susses ")
            .locatedBy(("#bundle-slide"));

}
