package com.magento.questions;

import com.magento.userinterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

/**
 * file packageco.com.demo.magento.questions
 */
public class RedirectPage implements Question<Boolean> {


    public static RedirectPage ToHome() {
        return new RedirectPage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(
                        HomePage.GRAPHIC_CONTENT, isPresent()).forNoMoreThan(10).seconds()
        );
        return HomePage.GRAPHIC_CONTENT.isVisibleFor(actor);
    }
}
