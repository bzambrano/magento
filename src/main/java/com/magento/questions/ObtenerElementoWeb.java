package com.magento.questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * file packagecom.magento.interactions
 */
@AllArgsConstructor
public class ObtenerElementoWeb implements Question<Target> {

    private static final String TEXT_LOCATOR = "//div[@class='product details product-item-details']//a[contains(text(),\"%s\")]";
    private String nameProduct;

    public static ObtenerElementoWeb porNombreProducto(String nameProduct) {
        return new ObtenerElementoWeb(nameProduct);
    }

    @Override
    public Target answeredBy(Actor actor) {
        String byLocator = String.format(TEXT_LOCATOR, nameProduct);
        return Target.the(String.format("el elemento web del producto %s", nameProduct))
                .located(By.xpath(byLocator));
    }
}
