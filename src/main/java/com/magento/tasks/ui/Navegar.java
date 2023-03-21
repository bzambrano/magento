package com.magento.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * file packageco.com.demo.magento.tasks.ui
 */
public class Navegar implements Task {

    private final String KEY_CALLED_BY_ACTOR;

    public Navegar(String keyCalledByActor) {
        this.KEY_CALLED_BY_ACTOR = keyCalledByActor;
    }

    public static Navegar paginaWeb(String urlSitio){
        return new Navegar(urlSitio);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(KEY_CALLED_BY_ACTOR)
        );
    }
}
