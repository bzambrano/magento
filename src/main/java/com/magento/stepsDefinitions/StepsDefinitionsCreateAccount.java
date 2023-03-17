package com.magento.stepsDefinitions;

import com.magento.helpers.ToRemember;
import com.magento.helpers.models.UserAccount;
import com.magento.interactions.Fill;
import com.magento.questions.*;
import com.magento.tasks.Login;
import com.magento.tasks.Sign;
import com.magento.tasks.ui.FillOutRegistrationForm;
import com.magento.tasks.ui.Navigate;
import com.magento.userinterface.RegistrationFormPage;
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
public class StepsDefinitionsCreateAccount {

    private static final String SUCCESS_MESSAGE = "Thank you for registering with Main Website Store.";
    private static final String URL_BASE_REGISTRO = theActorInTheSpotlight().recall(ToRemember.URL_REGISTER.name());
    private UserAccount userAccount;

    @Dado("que {actor} se encuentra en la pagina de registro y quiere hacer el registro para poder hacer las compras en la plataforma de LUMA")
    public void que_juan_se_encuentra_en_la_pagina_de_registro_y_quiere_hacer_el_registro_para_poder_hacer_las_compras_en_la_plataforma_de_luma(Actor actor) {
        theActorInTheSpotlight().attemptsTo(
                Navigate.webPage(URL_BASE_REGISTRO));
    }

    @Cuando("Diligencia los campos requeridos en el formulario y envia la infomacion")
    public void diligencia_los_campos_requeridos_en_el_formulario_y_envia_la_infomacion() {
        theActorInTheSpotlight().attemptsTo(
                FillOutRegistrationForm.withRandomValues(),
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT)
        );
    }

    @Entonces("El sistema me debe indicar que el registro fue exitoso")
    public void el_sistema_me_debe_indicar_que_el_registro_fue_exitoso() {

        userAccount = theActorInTheSpotlight().recall(ToRemember.USER_ACCOUNT.name());
        List<String> listDateInformation = userAccount.getAccountDataList();

                theActorInTheSpotlight().should(
                        seeThat(AccountInformation.value(),
                                equalTo(listDateInformation)
                        ),
                        seeThat(SuccessLogMessage.value(),
                                equalTo(SUCCESS_MESSAGE)),
                        seeThat(NameInToWelcomeMessage.value(),
                                containsString(userAccount.getFirstName())),
                        seeThat(NameInToWelcomeMessage.value(),
                                containsString(userAccount.getLastName())
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
                Login.by(userAccount)
        );

        theActorInTheSpotlight().should(
                seeThat(NameInToWelcomeMessage.value(),
                        containsString(userAccount.getFirstName())),
                seeThat(
                        NameInToWelcomeMessage.value(),
                        containsString(userAccount.getLastName()))
        );
    }

    @Dado("que {actor} se encuentra diligenciado el formulario de registro")
    public void quePedroSeEncuentraDiligenciadoElFormularioDeRegistro(Actor actor) {
        actor.attemptsTo(
                Navigate.webPage(URL_BASE_REGISTRO)
        );
    }

    @Cuando("se intenta crear una cuenta con campos vacios")
    public void ingresaValoresIncorrectosEnLosCamposRequeridos() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT)
        );
    }

    @Entonces("se deben mostrar las alertas para cada campo")
    public void seDebenMostrarLasAlertasParaCadaCampo() {
        String messageRequiredField = "This is a required field.";

        theActorInTheSpotlight().should(
                seeThat(IsAlert.inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_FIRST_NAME),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_LAST_NAME),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_EMAIL),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_PASSWORD),
                        equalTo(messageRequiredField)
                ), seeThat(IsAlert.inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_PASSWORD_CONFIRMATION),
                        equalTo(messageRequiredField)
                )
        );
    }

    @Entonces("al diligenciar el campo la alerta no se debe mostrar")
    public void alDiligenciarElCampoLaAlertaNoSeDebeMostrar() {
        userAccount = new UserAccount();
        userAccount.setDataUser();

        theActorInTheSpotlight().attemptsTo(
                Fill.field(RegistrationFormPage.INPUT_FIRST_NAME, userAccount.getFirstName()),
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT));

        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_FIRST_NAME),
                        equalTo(false))
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(RegistrationFormPage.INPUT_LAST_NAME, userAccount.getLastName()),
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT)

        );

        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_LAST_NAME),
                        equalTo(false))
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(RegistrationFormPage.INPUT_EMAIL, userAccount.getEmail()),
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT)
        );
        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_EMAIL),
                        equalTo(false)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(RegistrationFormPage.INPUT_PASSWORD, userAccount.getPassword()),
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT)
        );
        theActorInTheSpotlight().should(
                seeThat(IsAlertPresent
                                .inTheField(RegistrationFormPage.ALERT_FIELD_INPUT_EMAIL),
                        equalTo(false)
                )
        );

        theActorInTheSpotlight().attemptsTo(
                Fill.field(RegistrationFormPage.INPUT_PASSWORD_CONFIRMATION, userAccount.getPassword()),
                Click.on(RegistrationFormPage.BTN_CREATE_ACCOUNT)
        );
        theActorInTheSpotlight().should(
                seeThat(AccountInformation.value(),
                        equalTo(userAccount.getAccountDataList()
                        )
                )
        );
    }


}
