package com.magento.questions;

import com.magento.userinterface.PaginaEquipoEntrenamiento;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * file packagecom.magento.questions
 */
@AllArgsConstructor
public class NombresProductosDisponibles implements Question<List<String>> {


    public static NombresProductosDisponibles enPagina() {
        return new NombresProductosDisponibles();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        List<String> listaNombres = new ArrayList<>();
        ListOfWebElementFacades listaElementosWeb = PaginaEquipoEntrenamiento.NOMBRE_PRODUCTOS
                .resolveAllFor(actor);
        listaElementosWeb.forEach(e -> listaNombres.add(e.getText()));
        return listaNombres;
    }


}
