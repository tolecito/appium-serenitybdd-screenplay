package org.automation.appium.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProductDetailsScreen {

    public static Target PRODUCT_DETAIL_LABEL;

    public static Target ADD_TO_CART_BUTTON = Target.the("Boton Add to Cart")
            .located(AppiumBy.androidUIAutomator("new UiSelector().description(\"test-ADD TO CART\")"));

    public static Target TEXT_BUTTON = Target.the("Texto Boton")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")"));

    public static Target addLocator(String texto) {
        PRODUCT_DETAIL_LABEL = Target.the("Texto Detalle Producto")
                .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + texto + "\")"));

        return PRODUCT_DETAIL_LABEL;
    }
}
