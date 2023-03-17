package com.magento.questions;

import com.magento.userinterface.HomePage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * file packagecom.magento.questions
 */
@AllArgsConstructor
public class TheResponseLogin implements Question<Boolean> {

    private static final String TYPE_CREDENTIAL_VALID = "Validos";
    private String typeLogin;

    public static TheResponseLogin By(String typeLogin) {
        return new TheResponseLogin(typeLogin);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        if (typeLogin.equals(TYPE_CREDENTIAL_VALID)){
            return HomePage.GRAPHIC_CONTENT.isVisibleFor(actor);
        }else {
            return HomePage.MESSAGE_ERROR_LOGIN.isVisibleFor(actor);
        }
    }
}
