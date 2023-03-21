package com.magento.stepsDefinitions;

import com.magento.helpers.models.Producto;
import com.magento.questions.ProductosAgregado;
import com.magento.questions.UrlBySection;
import com.magento.tasks.AddProducts;
import com.magento.tasks.Ingresar;
import com.magento.tasks.ui.Navigate;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


/**
 * file packagecom.magento.stepsDefinitions
 */
public class StepsDefinitionsSelectProduct {
    private List<Producto> listaProductos;

    @Dado("que {actor} se encuentra en la seccion de {}")
    public void quePedroSeEncuentraEnLaSeccionDeTeesWomen(Actor actor, String section) {
        String sectionUrl = actor.asksFor(UrlBySection.value(section));
        actor.attemptsTo(
                Navigate.webPage(sectionUrl)
        );
    }

    @Cuando("selecciona los productos {}")
    public void seleccionaLosProductosDesireeFitnessTeeTiffanyFitnessTeeGabrielleMicroSleeveTop(String nombresProductos) {
        listaProductos = Producto.obtenerListasPor(nombresProductos);
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toShoppingCart(listaProductos)
        );
    }

    @Entonces("al ingresar al carro de compras se deben mostrar los productos seleccionados")
    public void alIngresarAlCorroDeComprasSeDebenMostrarLosProductosSeleccionados() {
        theActorInTheSpotlight().attemptsTo(
                Ingresar.CarroCompras()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        ProductosAgregado.enCarritoCompras(listaProductos), equalTo(true)
                )
        );

    }
}
