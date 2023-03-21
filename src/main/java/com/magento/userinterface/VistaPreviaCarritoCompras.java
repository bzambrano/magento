package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * file packagecom.magento.userinterface
 */
public class VistaPreviaCarritoCompras extends PageObject {

    public static final Target BTN_PASAR_CAJA = Target.the("Botón para iniciar sesión")
            .locatedBy("//a[@class='login']");


    public static final Target VINCULO_VER_EDITAR_CARRITO = Target.the("Botón para iniciar sesión")
            .locatedBy("#ui-id-1 A.viewcart");

}
