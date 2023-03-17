package com.magento.tasks;

import com.magento.userinterface.HeaderPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;

/**
 * file packageco.com.demo.magento.tasks
 */
public class Sign implements Task {

    public static Sign Out() {
        return new Sign();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean theUserIsLoggedIn =!(Presence.of(HeaderPage.ANCHOR_SIGN_IN).answeredBy(actor));
        if (theUserIsLoggedIn) {

            actor.attemptsTo(
                    Click.on(HeaderPage.BTN_DROPDOWN),
                    Click.on(HeaderPage.BTN_SIGN_OUT)
            );
        }
    }
}
