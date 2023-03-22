package com.magento.definitions;

import com.magento.helpers.Recordar;
import com.magento.helpers.models.FiltroCompra;
import com.magento.helpers.models.Producto;
import com.magento.questions.NombresProductosDisponibles;
import com.magento.questions.ProductosAgregado;
import com.magento.tasks.AgregarProductos;
import com.magento.tasks.AplicarFiltro;
import com.magento.tasks.Ingresar;
import com.magento.tasks.ui.Navegar;
import com.magento.utils.DestallesProducto;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

/**
 * file packagecom.magento.definitions
 */
public class FiltroProducto {

    private int numeroDeProductos = 4;


    @Dado("que {actor} se encuentra en la pagina Gear-FitnessEquipement")
    public void a(Actor actor) {
        String urlSitio = actor.recall(Recordar.URL_EQUIPO_EQUIPO_ENTRENAMIENTO.name());
        actor.attemptsTo(
                Navegar.paginaWeb(urlSitio)
        );
    }


    @Cuando("Aplica los filtros de opcion de compara {} y {}")
    public void b(String filtroUno, String filtroDos) {
        List<FiltroCompra> filtrosCompra = FiltroCompra.obtenerFiltro(filtroUno, filtroDos);
        theActorInTheSpotlight().attemptsTo(
                AplicarFiltro.opcionCampra(filtrosCompra)
        );
    }

    @Entonces("Debe poder seleccionar los productos luego de aplicar filtros")
    public void c() {
        List<String> listaProductosPantalla =
                theActorInTheSpotlight().asksFor(NombresProductosDisponibles.enPagina());
        List<Producto> listaProductos = Producto.obtenerListasPor(listaProductosPantalla);

        theActorInTheSpotlight().attemptsTo(
                AgregarProductos.alCarritoCompras(DestallesProducto.obtenerSubLista(listaProductos,numeroDeProductos)),
                Ingresar.CarroCompras()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        ProductosAgregado.enCarritoCompras(listaProductos), equalTo(true)
                )
        );
    }


}
