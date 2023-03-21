package com.magento.questions;

import com.magento.userinterface.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * file packagecom.magento.questions
 */
public class ProductIsAddedMessage implements Question<Boolean> {


    public static ProductIsAddedMessage inDisplayed() {
        return new ProductIsAddedMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ProductPage.MESSAGE_SUSSES.isVisibleFor(actor);
    }
}
