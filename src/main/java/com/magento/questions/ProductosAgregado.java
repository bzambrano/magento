package com.magento.questions;

import com.magento.helpers.models.Producto;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

/**
 * file packagecom.magento.questions
 */
@AllArgsConstructor
public class ProductosAgregado implements Question<Boolean> {

    private static final String TEXTO_LOCALIZADOR = "//tbody[@class='cart item']//descendant::a[contains(text(),'%s')]";
    private List<Producto> listaProductos;

    public static ProductosAgregado enCarritoCompras(List<Producto> listaProductos) {
        return new ProductosAgregado(listaProductos);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int numeroProductos =
                listaProductos.stream()
                .filter(producto -> Target.the("")
                        .locatedBy(String.format(TEXTO_LOCALIZADOR,
                                producto.getNombre()))
                        .isVisibleFor(actor)
                ).collect(Collectors.toList()).size();
        return  numeroProductos == this.listaProductos.size();
    }
}
