package org.automation.appium.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.questions.targets.TheTarget.textOf;

public class ValidationMessage implements Question<String> {

    private final Target target;

    public ValidationMessage(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return textOf(target).answeredBy(actor);
    }

    /*public static ValidationMessage isVisible() {
        return new ValidationMessage();
    }*/

    public static ValidationMessage of(Target target) {
        return new ValidationMessage(target);
    }
}

