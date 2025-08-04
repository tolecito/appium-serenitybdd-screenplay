package org.automation.appium.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsScreen
{
    public static Target asignarLocalizador(String nombreProducto) {
        NAME_PRODUCT_LABEL = Target.the("Texto Nombre Producto")
                .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + nombreProducto + "\")"));

        System.out.println("Localizador asignado para el producto: " + NAME_PRODUCT_LABEL);

        return NAME_PRODUCT_LABEL;
    }

    public static Target asignarLocalizadorPrecioProducto(String precioProducto) {
        PRICE_PRODUCT_LABEL = Target.the("Texto Nombre Producto")
                .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"" + precioProducto + "\")"));

        System.out.println("Localizador asignado para el producto: " + PRICE_PRODUCT_LABEL);

        return PRICE_PRODUCT_LABEL;
    }

    public static final Target PRODUCTS_LABEL = Target.the("Titulo Pantalla")
            //.located(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"PRODUCTS\")"));

    public static final Target TYPE_VIEW_BUTTON = Target.the("Boton Tipo Vista")
            .located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)"));

    public static final Target FILTERS_BUTTON = Target.the("Boton Filtros")
            .located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)"));

    public static Target NAME_PRODUCT_LABEL;

    public static Target PRICE_PRODUCT_LABEL;

    public static final Target SCROLL_CONTAINER = Target.the("Contenedor Scroll")
            .located(AppiumBy.accessibilityId("test-PRODUCTS"));

    //NOMBRE PRODUCTOS
    public static final Target PRODUCT_1 = Target.the("Texto Producto 1")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));

    public static final Target PRODUCT_2 = Target.the("Texto Producto 2")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Bike Light\")"));

    public static final Target PRODUCT_3 = Target.the("Texto Producto 3")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Bolt T-Shirt\")"));

    public static final Target PRODUCT_4 = Target.the("Texto Producto 4")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Fleece Jacket\")"));

    public static final Target PRODUCT_5 = Target.the("Texto Producto 5")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Onesie\")"));

    public static final Target PRODUCT_6 = Target.the("Texto Producto 6")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"Test.allTheThings() T-Shirt (Red)\")"));

    //PRECIO PRODUCTOS
    public static final Target PRICE_1 = Target.the("Texto Precio 1")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"$29.99\")"));

    public static final Target PRICE_2 = Target.the("Texto Precio 2")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"$9.99\")"));

    public static final Target PRICE_3 = Target.the("Texto Precio 3")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"$15.99\")"));

    public static final Target PRICE_4 = Target.the("Texto Precio 4")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"$49.99\")"));

    public static final Target PRICE_5 = Target.the("Texto Precio 5")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"$7.99\")"));

    public static final Target PRICE_6 = Target.the("Texto Precio 6")
            .located(AppiumBy.androidUIAutomator("new UiSelector().text(\"$15.99\").instance(1)"));

}
