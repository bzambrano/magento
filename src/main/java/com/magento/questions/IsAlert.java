package com.magento.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.targets.Target;

/**
 * file packagecom.magento.questions
 */
@AllArgsConstructor
public class IsAlert implements Question<String> {

    private Target elementWeb;

    public static IsAlert inTheField(Target elementWeb) {
        return new IsAlert(elementWeb);
    }

    @Override
    public String answeredBy(Actor actor) {
        return TextContent.of(elementWeb).answeredBy(actor);
    }
}
