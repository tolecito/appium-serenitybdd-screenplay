package org.automation.appium.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.targets.TheTarget.textOf;

public class ValidationText implements Question<String> {

    private final Target target;

    public ValidationText(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        // Espera explícita antes de obtener el texto
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds()
        );

        return textOf(target).answeredBy(actor);
    }

    public static ValidationText of(Target target) {
        return new ValidationText(target);
    }
}

