package org.automation.appium.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.automation.appium.interactions.TapElement;
import org.automation.appium.screens.LoginScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {
    private final String username;
    private final String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTask withCredentials(String username, String password) {
        return instrumented(LoginTask.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            TapElement.on(LoginScreen.USERNAME_FIELD),
            SendKeys.of(username).into(LoginScreen.USERNAME_FIELD),
            TapElement.on(LoginScreen.PASSWORD_FIELD),
            SendKeys.of(password).into(LoginScreen.PASSWORD_FIELD),
            TapElement.on(LoginScreen.LOGIN_BUTTON)
        );

    }
}