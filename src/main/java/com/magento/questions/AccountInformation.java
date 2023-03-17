package com.magento.questions;

import com.magento.userinterface.MyAccountPages;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * file packageco.com.demo.magento.questions
 */
public class AccountInformation implements Question<List<String>> {


    public static AccountInformation value() {
        return new AccountInformation();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        String userInformation = actor.asksFor(
                        Text.of(MyAccountPages.CONTACT_INFORMATION));
        return  Arrays.stream(userInformation.split("\\s"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
