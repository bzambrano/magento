package com.magento.definitions;

import com.magento.helpers.Recordar;
import com.magento.helpers.models.CuentaUsuario;
import com.magento.interactions.Fill;
import com.magento.questions.*;
import com.magento.tasks.Login;
import com.magento.tasks.Sign;
import com.magento.tasks.ui.ViligenciarFormuliarioInscripcion;
import com.magento.tasks.ui.Navegar;
import com.magento.userinterface.PaginaFormularioInscripcion;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * file packageco.com.demo.magento.stepsDefinitions
 */
public class CrearCuenta {

    private static final String MENSAJE_REGISTRO_EXITOSO = "Thank you for registering with Main Website Store.";
    private static final String URL_REGISTRO = theActorInTheSpotlight().recall(Recordar.URL_REGISTRO.name());
    private CuentaUsuario cuentaUsuario;

    @Dado("que {actor} se encuentra en la pagina de registro y quiere hacer el registro para poder hacer las compras en la plataforma de LUMA")
    public void que_juan_se_encuentra_en_la_pagina_de_registro_y_quiere_hacer_el_registro_para_poder_hacer_las_compras_en_la_plataforma_de_luma(Actor actor) {
        theActorInTheSpotlight().attemptsTo(
                Navegar.paginaWeb(URL_REGISTRO));
    }

    @Cuando("Diligencia los campos requeridos en el formulario y envia la infomacion")
    public void diligencia_los_campos_requeridos_en_el_formulario_y_envia_la_infomacion() {
        theActorInTheSpotlight().attemptsTo(
                ViligenciarFormuliarioInscripcion.conValoresAleatorios(),
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT)
        );
    }

    @Entonces("El sistema me debe indicar que el registro fue exitoso")
    public void el_sistema_me_debe_indicar_que_el_registro_fue_exitoso() {

        cuentaUsuario = theActorInTheSpotlight().recall(Recordar.CUENTA_USUARIO.name());
        List<String> listDateInformation = cuentaUsuario.getAccountDataList();

                theActorInTheSpotlight().should(
                        seeThat(AccountInformation.value(),
                                equalTo(listDateInformation)
                        ),
                        seeThat(SuccessLogMessage.value(),
                                equalTo(MENSAJE_REGISTRO_EXITOSO)),
                        seeThat(NameInToWelcomeMessage.value(),
                                containsString(cuentaUsuario.getFirstName())),
                        seeThat(NameInToWelcomeMessage.value(),
                                containsString(cuentaUsuario.getLastName())
                        )
                );

        theActorInTheSpotlight().attemptsTo(
                Sign.Out()
        );

        theActorInTheSpotlight().should(
                seeThat(RedirectPage.ToHome(),
                        equalTo(true))
        );
    }

    @Entonces("al hacer el login con las mismas credenciales del registro se debe ingresar de forma correcta")
    public void alHacerElLoginConLasMismasCredencialesDelRegistroSeDebeIngresarDeFormaCorrecta() {
        theActorInTheSpotlight().attemptsTo(
                Login.by(cuentaUsuario)
        );

        theActorInTheSpotlight().should(
                seeThat(NameInToWelcomeMessage.value(),
                        containsString(cuentaUsuario.getFirstName())),
                seeThat(
                        NameInToWelcomeMessage.value(),
                        containsString(cuentaUsuario.getLastName()))
        );
    }

    @Dado("que {actor} se encuentra diligenciado el formulario de registro")
    public void quePedroSeEncuentraDiligenciadoElFormularioDeRegistro(Actor actor) {
        actor.attemptsTo(
                Navegar.paginaWeb(URL_REGISTRO)
        );
    }

    @Cuando("se intenta crear una cuenta con campos vacios")
    public void ingresaValoresIncorrectosEnLosCamposRequeridos() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT)
        );
    }

    @Entonces("se deben mostrar las alertas para cada campo")
    public void seDebenMostrarLasAlertasParaCadaCampo() {
        String messageRequiredField = "This is a required field.";

        theActorInTheSpotlight().should(
                seeThat(IsAlert.inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_FIRST_NAME),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_LAST_NAME),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_EMAIL),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_PASSWORD),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_PASSWORD_CONFIRMATION),
                        equalTo(messageRequiredField)
                )
        );
    }

    @Entonces("al diligenciar el campo la alerta no se debe mostrar")
    public void alDiligenciarElCampoLaAlertaNoSeDebeMostrar() {
        cuentaUsuario = new CuentaUsuario();
        cuentaUsuario.setDataUser();

        theActorInTheSpotlight().attemptsTo(
                Fill.field(PaginaFormularioInscripcion.INPUT_FIRST_NAME, cuentaUsuario.getFirstName()),
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT));

        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_FIRST_NAME),
                        equalTo(false))
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(PaginaFormularioInscripcion.INPUT_LAST_NAME, cuentaUsuario.getLastName()),
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT)

        );

        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_LAST_NAME),
                        equalTo(false))
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(PaginaFormularioInscripcion.INPUT_EMAIL, cuentaUsuario.getEmail()),
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT)
        );
        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_EMAIL),
                        equalTo(false)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(PaginaFormularioInscripcion.INPUT_PASSWORD, cuentaUsuario.getPassword()),
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT)
        );
        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(PaginaFormularioInscripcion.ALERT_FIELD_INPUT_EMAIL),
                        equalTo(false)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(PaginaFormularioInscripcion.INPUT_PASSWORD_CONFIRMATION, cuentaUsuario.getPassword()),
                Click.on(PaginaFormularioInscripcion.BTN_CREATE_ACCOUNT)
        );
        theActorInTheSpotlight().should(
                seeThat(AccountInformation.value(),
                        equalTo(cuentaUsuario.getAccountDataList()
                        )
                )
        );
    }


}
