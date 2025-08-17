package org.automation.appium.tasks.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.automation.appium.interactions.ScrollToItem;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchFor implements Task {

    private final String texto;

    public SearchFor(String texto) {
        this.texto = texto;
    }

    public static SearchFor item(String texto) {
        return instrumented(SearchFor.class, texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //TapElement.on(ProductsScreen.SCROLL_CONTAINER), //Se da click al contenedor de scroll
                ScrollToItem.untilVisible(this.texto)
        );

    }
}
