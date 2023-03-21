package com.magento.questions;

import com.magento.helpers.Recordar;
import com.magento.helpers.models.CuentaUsuario;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * file packagecom.magento.interactions
 */
@AllArgsConstructor
public class GetUserValid implements Question<CuentaUsuario> {

    public static final String TYPE_CREDENTIAL_VALID = "Validos";
    private CuentaUsuario cuentaUsuario;

    public static GetUserValid value(CuentaUsuario cuentaUsuario) {
        return new GetUserValid(cuentaUsuario);
    }

    @Override
    public CuentaUsuario answeredBy(Actor actor) {
        cuentaUsuario.setDataUser();
        if ((actor.recall(Recordar.TIPO_LOGIN.name())).equals(TYPE_CREDENTIAL_VALID) ) {
            cuentaUsuario.setEmail(actor.recall(Recordar.EMAIL_USUARIO.name()));
            cuentaUsuario.setPassword(actor.recall(Recordar.PASSWORD_USUARIO.name()));
        }
        return cuentaUsuario;
    }
}
