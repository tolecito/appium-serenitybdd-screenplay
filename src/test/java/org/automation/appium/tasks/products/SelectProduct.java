package org.automation.appium.tasks.products;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.automation.appium.screens.ProductsScreen;
import org.automation.appium.tasks.common.SelecItem;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProduct implements Task {

    private final String productName;

    public SelectProduct(String productName) {
        this.productName = productName;
    }

    public static SelectProduct called(String productName) {
        return instrumented(SelectProduct.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target item = ProductsScreen.addLocator(this.productName);
        actor.attemptsTo(
                SelecItem.called(item)
        );

    }
}
