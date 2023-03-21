package com.magento.helpers.models;

import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * file packagecom.magento.helpers.models
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Producto {

    @NonNull
    private String nombre;
    private String talla;
    private String color;
    private Boolean stock;


    private static List<String> obtenerNombres(String texto) {
        return Arrays.stream(texto.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Producto> obtenerListasPor(String nombresProductos) {
        return obtenerNombres(nombresProductos)
                .stream()
                .map( Producto:: new)
                .collect(Collectors.toList());
    }

}
