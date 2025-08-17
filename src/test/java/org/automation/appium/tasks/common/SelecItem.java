package org.automation.appium.tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.automation.appium.interactions.TapElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelecItem implements Task {

    private final Target locator;

    public SelecItem(Target locator) {
        this.locator = locator;
    }

    public static SelecItem called(Target locator) {
        return instrumented(SelecItem.class, locator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //TapElement.on(ProductsScreen.SCROLL_CONTAINER), //Se da click al contenedor de scroll
                TapElement.on(this.locator)
        );

    }
}
