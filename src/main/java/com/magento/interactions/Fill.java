package com.magento.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * file packagecom.magento.interactions
 */
@AllArgsConstructor
public class Fill implements Interaction {

    private  Target inputWebElement;
    private  String text;

    public static Fill field(Target inputWebElement, String text){
        return instrumented(Fill.class,inputWebElement,text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(text).into(inputWebElement)
        );
    }
}
