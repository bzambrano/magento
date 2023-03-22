package com.magento.helpers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.magento.utils.ObtenerLista.obtenerLista;

/**
 * file packagecom.magento.helpers.models
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FiltroCompra {

    private  String opcion;
    private  String filtro;

    public static List<FiltroCompra> obtenerFiltro(String... parametroFiltro) {
        List<FiltroCompra> list = new ArrayList<>();
        for (String f : parametroFiltro) {
            List<String> listaFiltro = obtenerLista(f, ",");
            if (!listaFiltro.isEmpty()) {
                list.add(new FiltroCompra(
                        listaFiltro.get(0)
                        , listaFiltro.get(1)
                ));
            }
        }

        return list;
    }


}
