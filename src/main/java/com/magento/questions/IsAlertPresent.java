package com.magento.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

/**
 * file packagecom.magento.questions
 */
@AllArgsConstructor
public class IsAlertPresent implements Question<Boolean> {

    private Target alertFieldInput;

    public static IsAlertPresent inTheField(Target alertFieldInput) {
        return new IsAlertPresent(alertFieldInput);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return alertFieldInput.isVisibleFor(actor);
    }
}
