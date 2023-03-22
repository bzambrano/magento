package com.magento.definitions;

import com.magento.helpers.Recordar;
import com.magento.helpers.models.Producto;
import com.magento.questions.NombresProductosDisponibles;
import com.magento.tasks.AgregarProductos;
import com.magento.tasks.Ingresar;
import com.magento.tasks.ui.Navegar;
import com.magento.userinterface.HomePage;
import com.magento.userinterface.PaginaFiltro;
import com.magento.utils.DestallesProducto;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * file packagecom.magento.definitions
 */
public class RealizarCompra {


    @Dado("que {actor} desea realizar la compra de productos")
    public void actorDeseaRealizarCompraProductos(Actor actor) {
        String urlBase = actor.recall(Recordar.URL_BASE.name());
        actor.attemptsTo(
                Navegar.paginaWeb(urlBase),
                Click.on(HomePage.BARRA_MENU_WOMEN),
                Click.on(PaginaFiltro.FILTRO_TOPS)

        );
    }

    @Dado("ha seleccionado dos productos de dos categorias diferentes")
    public void seleccionaDosProductosDosCategoriasDiferentes() {

        List<String> listaProductosPantallaWomen =
                theActorInTheSpotlight().asksFor(NombresProductosDisponibles.enPagina());
        List<Producto> listaProductos = Producto.obtenerListasPor(listaProductosPantallaWomen);
        List<Producto> listaProductosAgregadosCarroComprasWomen = DestallesProducto.obtenerSubLista(listaProductos, 2);

        theActorInTheSpotlight().attemptsTo(
                AgregarProductos.alCarritoCompras(listaProductosAgregadosCarroComprasWomen),
                Click.on(HomePage.BARRA_MENU_MEN),
                Click.on(PaginaFiltro.FILTRO_TOPS)
        );


        List<String> listaProductosPantallaMen =
                theActorInTheSpotlight().asksFor(NombresProductosDisponibles.enPagina());
        listaProductos = Producto.obtenerListasPor(listaProductosPantallaMen);
        List<Producto> listaProductosAgregadosCarroComprasMen = DestallesProducto.obtenerSubLista(listaProductos, 2);

        theActorInTheSpotlight().attemptsTo(
                AgregarProductos.alCarritoCompras(listaProductosAgregadosCarroComprasMen),
                Ingresar.CarroCompras(),
                Click.on("//span[contains(text(),'Proceed to Checkout')]//ancestor::button")
        );

    }

    @Cuando("realiza el proceso de compra")
    public void realizaElProcesoDeCompra(String filtroUno, String filtroDos) {

    }

    @Entonces("se debe indicar que la compra fue exitosa")
    public void seDebeIndicarQueLaCompraFueExitosa() {

    }

}
