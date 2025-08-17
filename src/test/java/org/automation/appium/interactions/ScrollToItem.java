package org.automation.appium.interactions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.NoSuchElementException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollToItem implements Task {

    private final String text;
    private final Target locator;

    public ScrollToItem(String text) {
        this.text = text;
        this.locator = null;
    }

    public static ScrollToItem untilVisible(String text) {
        return instrumented(ScrollToItem.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        AndroidDriver driver = (AndroidDriver) BrowseTheWeb.as(actor).getDriver();

        boolean found = false;
        int maxScrolls = 20; // Limite de scrolls para evitar bucles infinitos

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

