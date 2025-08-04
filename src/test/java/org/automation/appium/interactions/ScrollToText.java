package org.automation.appium.interactions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.NoSuchElementException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*public class ScrollToText implements Task {

    private final Target locator;

    public ScrollToText(Target locator) {
        this.locator = locator;
    }

    public static ScrollToText named(Target locator) {
        return instrumented(ScrollToText.class, locator);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Scroll.to(this.locator)
        );
    }
}*/

public class ScrollToText implements Task {

    private final String text;

    public ScrollToText(String text) {
        this.text = text;
    }

    public static ScrollToText untilVisible(String text) {
        return instrumented(ScrollToText.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();

        boolean found = false;
        int maxScrolls = 5;

        while (!found && maxScrolls-- > 0) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
                found = true;
            } catch (NoSuchElementException e) {
                // Optional: puedes hacer un swipe manual si el scrollable no sirve
            }
        }

        if (!found) {
            throw new RuntimeException("No se encontró el texto: " + text);
        }
    }
}

