package com.magento.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * file packageco.com.demo.magento.tasks.ui
 */
public class Navigate implements Task {

    private final String KEY_CALLED_BY_ACTOR;

    public Navigate(String keyCalledByActor) {
        this.KEY_CALLED_BY_ACTOR = keyCalledByActor;
    }

    public static Navigate webPage(String siteUrl){
        return new Navigate(siteUrl);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(KEY_CALLED_BY_ACTOR)
        );
    }
}
