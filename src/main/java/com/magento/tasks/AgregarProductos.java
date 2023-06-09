package com.magento.tasks;

import com.magento.helpers.models.Producto;
import com.magento.interactions.AddToShoppingCart;
import com.magento.interactions.SelectAProduct;
import com.magento.interactions.SelectColor;
import com.magento.interactions.SelectSize;
import com.magento.questions.ObtenerElementoWeb;
import com.magento.questions.ProductIsAddedMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

/**
 * file packagecom.magento.tasks
 */
@RequiredArgsConstructor
public class AgregarProductos implements Task {

    @NonNull
    private List<Producto> listaProductos;

    public static AgregarProductos alCarritoCompras(List<Producto> listaProductos) {
        return new AgregarProductos(listaProductos);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Producto producto : listaProductos) {
            Target webElementProduct = actor.asksFor(ObtenerElementoWeb.porNombreProducto(producto.getNombre()));
            actor.attemptsTo(
                    SelectAProduct.byElement(webElementProduct),
                    SelectSize.theProduct(),
                    SelectColor.theProduct(),
                    AddToShoppingCart.theProduct()
            );
            actor.should(seeThat(ProductIsAddedMessage.inDisplayed()));
            BrowseTheWeb.as(actor).getDriver().navigate().back();
        }
    }
}
