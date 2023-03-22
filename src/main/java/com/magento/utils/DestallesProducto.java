package com.magento.utils;

import com.magento.helpers.models.Producto;

import java.util.Collections;
import java.util.List;

/**
 * file packagecom.magento.utils
 */
public class DestallesProducto {

    private DestallesProducto() {
    }


    public static List<Producto> obtenerSubLista(List<Producto> lista, int limite) {
        limite = (lista.size() >= limite) ? limite : lista.size();
        Collections.shuffle(lista);
        return lista.subList(0, limite);
    }
}
