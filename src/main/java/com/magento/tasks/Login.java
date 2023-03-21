package com.magento.tasks;

import com.magento.helpers.models.CuentaUsuario;
import com.magento.userinterface.HeaderPage;
import com.magento.userinterface.LoginPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

/**
 * file packagecom.magento.tasks
 */
@AllArgsConstructor
public class Login implements Task {

    private CuentaUsuario cuentaUsuario;

    public static Login by(CuentaUsuario cuentaUsuario) {
        return instrumented(Login.class, cuentaUsuario) ;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(HeaderPage.ANCHOR_SIGN_IN, isClickable()),
                Click.on(HeaderPage.ANCHOR_SIGN_IN),
                Enter.theValue(this.cuentaUsuario.getEmail()).into(LoginPage.INPUT_EMAIL),
                Enter.theValue(this.cuentaUsuario.getPassword()).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BTN_SIGN_IN)
        );
    }
}
