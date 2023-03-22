package com.magento.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * file packagecom.magento.userinterface
 */
public class PaginaFiltro extends  PageObject{

    public static final Target FILTRO_TOPS = Target.the(
                    "Filtro de Tops")
            .locatedBy("//a[contains(text(),'Tops')]");


}
