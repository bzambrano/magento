package com.magento.questions;

import com.magento.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

/**
 * file packagecom.magento.questions
 */
public class ProductIsAddedMessage implements Question<Boolean> {


    public static ProductIsAddedMessage inDisplayed() {
        return new ProductIsAddedMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(ProductPage.MESSAGE_SUSSES, isPresent())
        );
        return ProductPage.MESSAGE_SUSSES.isVisibleFor(actor);
    }
}
