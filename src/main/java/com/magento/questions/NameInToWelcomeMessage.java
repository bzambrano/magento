package com.magento.questions;

import com.magento.userinterface.MyAccountPages;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

/**
 * file packageco.com.demo.magento.questions
 */
public class NameInToWelcomeMessage implements Question<String> {


    public static NameInToWelcomeMessage value() {
    return new NameInToWelcomeMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MyAccountPages.WELCOME_MESSAGE_HEADER, isPresent())
        );
        return TextContent.of(MyAccountPages.WELCOME_MESSAGE_HEADER).answeredBy(actor);
    }
}
