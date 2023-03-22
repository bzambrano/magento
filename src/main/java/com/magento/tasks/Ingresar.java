package com.magento.tasks;

import com.magento.userinterface.HeaderPage;
import com.magento.userinterface.VistaPreviaCarritoCompras;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

/**
 * file packagecom.magento.tasks
 */
public class Ingresar implements Task {

    public static Ingresar CarroCompras() {
        return instrumented(Ingresar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HeaderPage.BTN_CARRO_COMPRAS),
                WaitUntil.the(VistaPreviaCarritoCompras.VINCULO_VER_EDITAR_CARRITO,
                        isPresent()),

                WaitUntil.the(VistaPreviaCarritoCompras.VINCULO_VER_EDITAR_CARRITO,
                        WebElementStateMatchers.isVisible()),
                Click.on(VistaPreviaCarritoCompras.VINCULO_VER_EDITAR_CARRITO)
        );
    }
}
