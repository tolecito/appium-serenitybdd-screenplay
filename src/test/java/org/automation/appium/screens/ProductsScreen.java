package org.automation.appium.screens;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsScreen
{
    public static final Target PRODUCTS_LABEL = Target.the("Titulo Pantalla")
            .located(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
}
