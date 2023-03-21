package com.magento.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;


/**
 * file packagecom.magento.interactions
 */
@AllArgsConstructor
public class SelectAProduct implements Interaction {

    private Target webElementProduct;

    public static SelectAProduct byElement(Target webElementProduct) {
        return new SelectAProduct(webElementProduct);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(webElementProduct)
        );
    }
}
