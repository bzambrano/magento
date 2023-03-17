package com.magento.tasks.ui;

import com.magento.helpers.ToRemember;
import com.magento.helpers.models.UserAccount;
import com.magento.userinterface.RegistrationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * file packageco.com.demo.magento.tasks
 */
public class FillOutRegistrationForm implements Task {


    public static Performable withRandomValues() {
        return instrumented(FillOutRegistrationForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UserAccount userAccount = new UserAccount();
        userAccount.setDataUser();
        actor.remember(ToRemember.USER_ACCOUNT.name(), userAccount);
        actor.attemptsTo(
                Enter.theValue(userAccount.getFirstName()).into(RegistrationForm.INPUT_FIRST_NAME),
                Enter.theValue(userAccount.getLastName()).into(RegistrationForm.INPUT_LAST_NAME),
                Enter.theValue(userAccount.getEmail()).into(RegistrationForm.INPUT_EMAIL),
                Enter.theValue(userAccount.getPassword()).into(RegistrationForm.INPUT_PASSWORD),
                Enter.theValue(userAccount.getPassword()).into(RegistrationForm.INPUT_PASSWORD_CONFIRMATION)
        );
    }
}
