package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * file packagecom.magento.userinterface
 */
public class PaginaEquipoEntrenamiento extends PageObject {

    public static final  Target ITEMS_PRODUCTOS =
            Target.the("Elementos que contiene las tarjetas de productos")
                    .locatedBy("//li[@class='item product product-item']");

    public static final Target NOMBRE_PRODUCTOS =
            Target.the("Elemento que contiene el nombre del producto")
                    .locatedBy("//li[@class='item product product-item']//descendant::strong");

}
