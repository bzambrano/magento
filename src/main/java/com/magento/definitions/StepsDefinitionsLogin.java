package com.magento.definitions;

import com.magento.helpers.Recordar;
import com.magento.helpers.models.CuentaUsuario;
import com.magento.questions.GetUserValid;
import com.magento.questions.TheResponseLogin;
import com.magento.tasks.Login;
import com.magento.tasks.ui.Navegar;
import com.magento.userinterface.HeaderPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

/**
 * file packagecom.magento.stepsDefinitions
 */
public class StepsDefinitionsLogin {

    private CuentaUsuario cuentaUsuario = new CuentaUsuario();
    private String typeLogin;

    @Dado("Que {actor} cuanto con usuario y contrasena {}")
    public void queCamiloCuantoConUsuarioYContrasenaNoValidos(Actor actor, String typeLogin) {
        this.typeLogin = typeLogin;
        actor.remember(Recordar.TIPO_LOGIN.name(), typeLogin);
        String urlHome = actor.recall(Recordar.URL_BASE.name());
        theActorInTheSpotlight().attemptsTo(
                Navegar.paginaWeb(urlHome),
                Click.on(HeaderPage.ANCHOR_SIGN_IN)
        );
    }

    @Cuando("diligencia los campos del formulario e inicio sesion")
    public void diligenciaLosCamposDelFormularioEInicioSesion() {
        cuentaUsuario = theActorInTheSpotlight().asksFor(GetUserValid.value(cuentaUsuario));
        theActorInTheSpotlight().attemptsTo(
                Login.by(cuentaUsuario)
        );
    }

    @Entonces("el sistema debe {}")
    public void elSistemaDebeDeneMostrarUnaAlertaIndicadoUnErrorEnLasCredenciales(String r) {
        theActorInTheSpotlight().should(
                seeThat(TheResponseLogin.By(typeLogin),
                        equalTo(true)
                )
        );
    }

}
