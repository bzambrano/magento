package com.magento.interactions;

import com.magento.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

/**
 * file packagecom.magento.interactions
 */
public class AddToShoppingCart implements Interaction {


    public static AddToShoppingCart theProduct() {
        return new AddToShoppingCart();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductPage.BTN_ADD_TO_CART)
        );
    }
}
