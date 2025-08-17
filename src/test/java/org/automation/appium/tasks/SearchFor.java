package org.automation.appium.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.automation.appium.interactions.ScrollToText;
import org.automation.appium.interactions.TapElement;

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
                ScrollToText.untilVisible(this.texto)
        );

    }
}
