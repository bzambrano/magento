package com.magento.tasks;

import com.magento.helpers.models.FiltroCompra;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * file packagecom.magento.tasks
 */
@AllArgsConstructor
public class AplicarFiltro implements Task {


    private static final String TEXTO_LOCALIZADOR_OPCION = "//div [contains(text(),'%s') and @class='filter-options-title']";
    private static final String TEXTO_LOCALIZADOR_FILTRO = "//ol[@class='items']//descendant::a[contains(text(),'%s')]";
    private List<FiltroCompra> filtroCompra;

    public static AplicarFiltro opcionCampra(List<FiltroCompra> filtroCompra) {
        return instrumented(AplicarFiltro.class, filtroCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (FiltroCompra filtro : filtroCompra) {
            Target webElementOpcion  = Target.the("opcion del filtro ")
                    .locatedBy(String.format(TEXTO_LOCALIZADOR_OPCION,filtro.getOpcion()));
             Target webElementFiltro = Target.the("Elemento del filtro")
                     .locatedBy(String.format(TEXTO_LOCALIZADOR_FILTRO,filtro.getFiltro()));
            actor.attemptsTo(
                    WaitUntil.the(webElementOpcion,isVisible()),
                    Click.on(webElementOpcion),
                    WaitUntil.the(webElementFiltro, isVisible()),
                    Click.on(webElementFiltro)
            );
        }
    }
}



