package com.magento.tasks.ui;

import com.magento.helpers.Recordar;
import com.magento.helpers.models.CuentaUsuario;
import com.magento.userinterface.PaginaFormularioInscripcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * file packageco.com.demo.magento.tasks
 */
public class ViligenciarFormuliarioInscripcion implements Task {


    public static Performable conValoresAleatorios() {
        return instrumented(ViligenciarFormuliarioInscripcion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CuentaUsuario cuentaUsuario = new CuentaUsuario();
        cuentaUsuario.setDataUser();
        actor.remember(Recordar.CUENTA_USUARIO.name(), cuentaUsuario);
        actor.attemptsTo(
                Enter.theValue(cuentaUsuario.getFirstName()).into(PaginaFormularioInscripcion.INPUT_FIRST_NAME),
                Enter.theValue(cuentaUsuario.getLastName()).into(PaginaFormularioInscripcion.INPUT_LAST_NAME),
                Enter.theValue(cuentaUsuario.getEmail()).into(PaginaFormularioInscripcion.INPUT_EMAIL),
                Enter.theValue(cuentaUsuario.getPassword()).into(PaginaFormularioInscripcion.INPUT_PASSWORD),
                Enter.theValue(cuentaUsuario.getPassword()).into(PaginaFormularioInscripcion.INPUT_PASSWORD_CONFIRMATION)
        );
    }
}
