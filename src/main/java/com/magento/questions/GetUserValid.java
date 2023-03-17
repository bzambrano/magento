package com.magento.questions;

import com.magento.helpers.ToRemember;
import com.magento.helpers.models.UserAccount;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * file packagecom.magento.interactions
 */
@AllArgsConstructor
public class GetUserValid implements Question<UserAccount> {

    public static final String TYPE_CREDENTIAL_VALID = "Validos";
    private UserAccount userAccount;

    public static GetUserValid value(UserAccount userAccount) {
        return new GetUserValid(userAccount);
    }

    @Override
    public UserAccount answeredBy(Actor actor) {
        userAccount.setDataUser();
        if ((actor.recall(ToRemember.TYPE_LOGIN.name())).equals(TYPE_CREDENTIAL_VALID) ) {
            userAccount.setEmail(actor.recall(ToRemember.USER_EMAIL.name()));
            userAccount.setPassword(actor.recall(ToRemember.USER_PASSWORD.name()));
        }
        return userAccount;
    }
}
