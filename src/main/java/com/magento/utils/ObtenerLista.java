package com.magento.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * file packagecom.magento.utils
 */
public class ObtenerLista {

    private ObtenerLista() {
    }

    public static List<String> obtenerLista(String texto, String separador) {
        return Arrays.stream(texto.split(separador))
                .map(String::trim)
                .collect(Collectors.toList());
    }



}
