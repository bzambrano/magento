package com.magento.interactions;

import com.magento.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

/**
 * file packagecom.magento.interactions
 */
public class SelectColor implements Interaction {


    public static SelectColor theProduct() {
        return new SelectColor();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (ProductPage.COLOR_ANY.isVisibleFor(actor)) {
            actor.attemptsTo(Click.
                    on(ProductPage.COLOR_ANY));
        }
    }
}
