package com.magento.interactions;

import com.magento.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

/**
 * file packagecom.magento.interactions
 */
public class AddToShoppingCart implements Interaction {


    public static AddToShoppingCart theProduct() {
        return new AddToShoppingCart();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (ProductPage.BTN_PERSONALIZAR_AGREGAR_CARRITO.isVisibleFor(actor)) {
            actor.attemptsTo(
                    WaitUntil.the(ProductPage.BTN_PERSONALIZAR_AGREGAR_CARRITO, isClickable()),
                    Click.on(ProductPage.BTN_PERSONALIZAR_AGREGAR_CARRITO)
            );
        }
        actor.attemptsTo(
                WaitUntil.the(ProductPage.BTN_ADD_TO_CART, isPresent()),
                Click.on(ProductPage.BTN_ADD_TO_CART)
        );
    }
}
