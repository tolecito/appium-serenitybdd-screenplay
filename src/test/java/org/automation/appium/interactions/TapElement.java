package org.automation.appium.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TapElement implements Interaction {
    //private final By locator;
    private final Target locator;

    /*public TapElement(By locator) {
        this.locator = locator;
    }*/

    public TapElement(Target locator) {
        this.locator = locator;

    }

    public static TapElement on(Target locator) {
        return instrumented(TapElement.class, locator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(this.locator)
        );
    }

}

