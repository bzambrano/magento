package com.magento.questions;

import com.magento.userinterface.MyAccountPages;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/**
 * file packageco.com.demo.magento.questions
 */
public class SuccessLogMessage implements Question<String> {

    public static SuccessLogMessage value() {
        return new SuccessLogMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(MyAccountPages.MESSAGE_SUCCESS));
    }
}
