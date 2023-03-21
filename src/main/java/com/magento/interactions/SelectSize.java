package com.magento.interactions;

import com.magento.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

/**
 * file packagecom.magento.interactions
 */
public class SelectSize implements Interaction {


    public static SelectSize theProduct() {
        return new SelectSize();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (ProductPage.SIZE_ANY.isVisibleFor(actor)){
            actor.attemptsTo(
                    Click.on(ProductPage.SIZE_ANY));
        }
    }
}
