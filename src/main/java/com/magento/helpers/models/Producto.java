package com.magento.helpers.models;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.magento.utils.ObtenerLista.obtenerLista;

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


    public static List<Producto> obtenerListasPor(String nombresProductos) {
        return obtenerLista(nombresProductos,",")
                .stream()
                .map( Producto:: new)
                .collect(Collectors.toList());
    }

    public static List<Producto> obtenerListasPor(List<String> nombresProductos) {
        return nombresProductos
                .stream()
                .map( Producto:: new)
                .collect(Collectors.toList());
    }

}
