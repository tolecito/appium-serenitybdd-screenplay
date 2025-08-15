package org.automation.appium.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.automation.appium.interactions.ScrollToText;
import org.automation.appium.interactions.TapElement;
import org.automation.appium.screens.ProductsScreen;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollTask implements Task {
    private final String texto;
    private final Target locator;

    public ScrollTask(String texto,Target locator) {
        this.texto = texto;
        this.locator = locator;
    }

    public static ScrollTask scrollAndClick(String texto,Target locator) {
        return instrumented(ScrollTask.class, texto, locator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            //TapElement.on(ProductsScreen.SCROLL_CONTAINER), //Se da click al contenedor de scroll
            ScrollToText.untilVisible(this.texto),
            TapElement.on(this.locator)
        );

    }
}